package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Animal;
import VetWithoutBorder.Entities.AnimalPK;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AnimalRepository {

    private Session session;

    // protected

    public AnimalRepository(@Autowired Session session) {
        this.session = session;
    }

    public Animal[] getAllv2() {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        query.from(Animal.class);

        List<Animal> animals = session.createQuery(query).getResultList();

        return animals.toArray(new Animal[animals.size()]);
    }

    public Animal[] searchByName(String name) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);

        Expression<String> path = root.get("name");
        Expression<String> lower = builder.lower(path);

        query.select(root).where(builder.like(lower, MatchMode.ANYWHERE.toMatchString(name.toLowerCase())));

        List<Animal> animals = session.createQuery(query).getResultList();

        return animals.toArray(new Animal[animals.size()]);
    }

    public Animal[] searchByClinicNo(String clinicNo) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);

        query.select(root).where(builder.equal(root.get("clinicNo"), clinicNo));

        List<Animal> animals = session.createQuery(query).getResultList();

        return animals.toArray(new Animal[animals.size()]);
    }

    public Animal[] searchByAnimalNo(Integer animalNo) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);

        query.select(root).where(builder.equal(root.get("animalNo"), animalNo));

        List<Animal> animals = session.createQuery(query).getResultList();

        return animals.toArray(new Animal[animals.size()]);
    }


    public Animal searchByPK(AnimalPK animalPK) {
        return this.session.get(Animal.class, animalPK);
    }
}
