package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Clinic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ClinicRepository extends AbstractRepository<Clinic, String> {

    ClinicRepository(@Autowired SessionFactory factory) {
        super(factory, Clinic.class);
    }

    public List<Clinic> searchByCity(String cityName){
        Session session = super.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Clinic> query = builder.createQuery(this.classType);
            Root<Clinic> root = query.from(this.classType);

            // TODO : convert to root.get("address.city"); #DontKnowWhyItDoesNotWork
            Expression<String> path = root.get("address").get("city");
            Expression<String> lower = builder.lower(path);

            query.select(root).where(builder.like(lower, MatchMode.ANYWHERE.toMatchString(cityName.toLowerCase())));

            List<Clinic> result = session.createQuery(query).getResultList();

            tx.commit();

            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
