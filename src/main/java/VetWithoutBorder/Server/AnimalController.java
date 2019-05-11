package VetWithoutBorder.Server;

import VetWithoutBorder.Database.*;
import VetWithoutBorder.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping(params = "name")
    public List<Animal> searchByName(@RequestParam(name = "name") String name) {
        return this.animalRepository.searchByName(name);
    }

    @GetMapping(params = "clinicNo")
    public List<Animal> getByClinicNo(@RequestParam(name = "clinicNo") String clinicNo) {
        return this.animalRepository.searchByClinicNo(clinicNo);
    }

    @GetMapping(params = "animalNo")
    public List<Animal> getByClinicNo(@RequestParam(name = "animalNo") Integer animalNo) {
        return this.animalRepository.searchByAnimalNo(animalNo);
    }

    @GetMapping(params = {"clinicNo",  "animalNo"})
    public Animal getByPK(@RequestParam(name = "clinicNo") String clinicNo,
                          @RequestParam(name = "animalNo") Integer animalNo) {
        Animal animal = this.animalRepository.findByPK(new AnimalPK(animalNo, clinicNo));
        if (animal != null) {
            return animal;
        }

        throw new EntityNotFoundError("animal");
    }

    @GetMapping(value = "")
    public List<Animal> getAnimals() {
        return this.animalRepository.findAll();
    }

    @PostMapping(value = "")
    public Animal insert(@RequestBody Animal animal){
        return this.animalRepository.insert(animal);
    }

    @PutMapping(params = {"clinicNo",  "animalNo"})
    public Animal updateField(@RequestBody Animal animal,
                              @RequestParam(name = "clinicNo") String clinicNo,
                              @RequestParam(name = "animalNo") Integer animalNo) {
        Animal oldAnimal = this.animalRepository.findByPK(new AnimalPK(animalNo, clinicNo));
        if (animal == null) {
            throw new EntityNotFoundError("animal");
        }


        if(animal.getOwnerNo() != null) {
            oldAnimal.setOwnerNo(animal.getOwnerNo());
        }
        if(animal.getType() != null) {
            oldAnimal.setType(animal.getType());
        }
        if(animal.getState() != null) {
            oldAnimal.setState(animal.getState());
        }
        if(animal.getDateOfBirth() != null) {
            oldAnimal.setDateOfBirth(animal.getDateOfBirth());
        }
        if(animal.getInscriptionDate() != null) {
            oldAnimal.setInscriptionDate(animal.getInscriptionDate());
        }
        if(animal.getDescription() != null){
            oldAnimal.setDescription(animal.getDescription());
        }

        return this.animalRepository.insert(oldAnimal);
    }
}
