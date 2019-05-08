package VetWithoutBorder.Server;

import VetWithoutBorder.Database.*;
import VetWithoutBorder.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
}
