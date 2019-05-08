package VetWithoutBorder.Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractRepository<TABLE, PK extends Serializable> {

    private SessionFactory factory;

    private Class<TABLE> classType;

    AbstractRepository(SessionFactory factory, Class<TABLE> classType) {
        this.factory = factory;
        this.classType = classType;
    }

    public List<TABLE> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
            query.from(this.classType);
            List<TABLE> result =  session.createQuery(query).getResultList();

            tx.commit();

            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public TABLE findByPK(PK pk) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
            query.from(this.classType);
            TABLE result =  session.get(this.classType, pk);

            tx.commit();

            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public TABLE insert(TABLE newValue) {


        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(newValue);
            tx.commit();

            return newValue;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    <T> List<TABLE> where(String attributeName, T attribute) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
            Root<TABLE> root = query.from(this.classType);

            query.select(root).where(builder.equal(root.get(attributeName), attribute));

            List<TABLE> result = session.createQuery(query).getResultList();

            tx.commit();

            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    List<TABLE> likeAnywhere(String attributeName, String attribute) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TABLE> query = builder.createQuery(this.classType);
            Root<TABLE> root = query.from(this.classType);

            Expression<String> path = root.get(attributeName);
            Expression<String> lower = builder.lower(path);

            query.select(root).where(builder.like(lower, MatchMode.ANYWHERE.toMatchString(attribute.toLowerCase())));

            List<TABLE> result = session.createQuery(query).getResultList();

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
