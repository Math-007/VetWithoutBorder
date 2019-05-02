package VetWithoutBorder.Server;

import VetWithoutBorder.Database.*;
import VetWithoutBorder.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping(params = {"clinicNo",  "animalNo"})
    public Animal getByPK(@RequestParam(name = "clinicNo") String clinicNo,
                          @RequestParam(name = "animalNo") Integer animalNo) {
        Optional<Animal> animal = this.animalRepository.findById(new AnimalPK(animalNo, clinicNo));
        if (animal.isPresent()) {
            return animal.get();
        }

        throw new EntityNotFoundError("animal");
    }

    @GetMapping(value = "")
    public List<Animal> getAnimals() {
        return this.animalRepository.findAll();
    }

    @GetMapping(params = "name")
    public List<Animal> searchByName(@RequestParam(name = "name") String name) {
        return this.animalRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping(params = "clinicNo")
    public List<Animal> getByClinicNo(@RequestParam(name = "clinicNo") String clinicNo) {
        return this.animalRepository.findByClinicNo(clinicNo);
    }

    @GetMapping(params = "animalNo")
    public List<Animal> getByClinicNo(@RequestParam(name = "animalNo") Integer animalNo) {
        return this.animalRepository.findByAnimalNo(animalNo);
    }
}
