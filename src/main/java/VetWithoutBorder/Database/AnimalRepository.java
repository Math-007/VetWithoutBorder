package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Animal;
import VetWithoutBorder.Entities.AnimalPK;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AnimalRepository extends AbstractRepository<Animal, AnimalPK> {

    public AnimalRepository(@Autowired SessionFactory factory) {
        super(factory, Animal.class);
    }

    public List<Animal> searchByName(String name) {
        return super.likeAnywhere("name", name);
    }

    public List<Animal> searchByClinicNo(String clinicNo) {
        return super.where("clinicNo", clinicNo);
    }

    public List<Animal> searchByAnimalNo(Integer animalNo) {
        return super.where("animalNo", animalNo);
    }
}
