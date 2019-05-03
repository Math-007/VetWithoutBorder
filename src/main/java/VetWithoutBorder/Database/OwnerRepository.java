package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Owner;
import VetWithoutBorder.Entities.OwnerPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, OwnerPK> {

    List<Owner> findAll();

    List<Owner> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    List<Owner> findByClinicNo(String clinicNo);
}
