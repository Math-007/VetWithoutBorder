package VetWithoutBorder.Database;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepository<TABLE, PK extends Serializable> {

    protected Session session;

    private Class<TABLE> classType;

    protected AbstractRepository(Session session, Class<TABLE> classType) {
        this.session = session;
        this.classType = classType;
    }

    // @SuppressWarnings("unchecked")
    public List<TABLE> findAll() {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
        query.from(this.classType);

        return session.createQuery(query).getResultList();
    }

    public TABLE findByPK(PK pk) {
        return this.session.get(this.classType, pk);
    }

    protected <T> List<TABLE> where(String attributeName, T attribute) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
        Root<TABLE> root = query.from(this.classType);

        query.select(root).where(builder.equal(root.get(attributeName), attribute));

        return session.createQuery(query).getResultList();
    }

    protected List<TABLE> likeAnywhere(String attributeName, String attribute) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
        Root<TABLE> root = query.from(this.classType);

        Expression<String> path = root.get(attributeName);
        Expression<String> lower = builder.lower(path);

        query.select(root).where(builder.like(lower, MatchMode.ANYWHERE.toMatchString(attribute.toLowerCase())));

        return this.session.createQuery(query).getResultList();
    }
}
