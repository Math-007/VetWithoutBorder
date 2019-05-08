package VetWithoutBorder.Server;

import VetWithoutBorder.Database.OwnerRepository;
import VetWithoutBorder.Entities.Owner;
import VetWithoutBorder.Entities.OwnerPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping(params = {"clinicNo", "ownerNo"})
    public Owner getByPK(@RequestParam(name = "clinicNo") String clinicNo,
                         @RequestParam(name = "ownerNo") String ownerNo) {
        Owner owner = this.ownerRepository.findByPK(new OwnerPK(ownerNo, clinicNo));
        if (owner != null) {
            return owner;
        }

        throw new EntityNotFoundError("owner");
    }

    @GetMapping(value = "")
    public List<Owner> getOwners() {
        return this.ownerRepository.findAll();
    }

    @GetMapping(params = "ownerName")
    public List<Owner> searchByName(@RequestParam(name = "ownerName") String name) {
        return this.ownerRepository.searchByOwnerName(name, name);
    }

    @GetMapping(params = "clinicNo")
    public List<Owner> getByClinicNo(@RequestParam(name = "clinicNo") String clinicNo) {
        return this.ownerRepository.searchByClinicNo(clinicNo);
    }
}