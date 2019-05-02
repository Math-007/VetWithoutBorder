package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Animal;
import VetWithoutBorder.Entities.AnimalPK;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, AnimalPK> {

    List<Animal> findByNameContainingIgnoreCase(String name);

    List<Animal> findByClinicNo(String clinicNo);

    List<Animal> findByAnimalNo(Integer animalNo);

    List<Animal> findAll();
}
