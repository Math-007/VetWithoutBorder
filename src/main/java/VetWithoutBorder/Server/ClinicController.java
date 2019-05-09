package VetWithoutBorder.Server;

import VetWithoutBorder.Database.ClinicRepository;
import VetWithoutBorder.Entities.Clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicRepository clinicRepository;

    public ClinicController(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @GetMapping(params = "city")
    public List<Clinic> searchByCity(@RequestParam(name = "city") String name) {
        return this.clinicRepository.searchByCity(name);
    }

    @GetMapping(params = "clinicNo")
    public Clinic getByPK(@RequestParam(name = "clinicNo") String clinicNo) {
        Clinic clinic = this.clinicRepository.findByPK(clinicNo);
        if (clinic != null) {
            return clinic;
        }

        throw new EntityNotFoundError("clinic");
    }

    @GetMapping(value = "")
    public List<Clinic> getClinics() {
        return this.clinicRepository.findAll();
    }
}
