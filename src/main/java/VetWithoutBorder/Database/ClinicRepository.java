package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Clinic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ClinicRepository extends AbstractRepository<Clinic, String> {

    ClinicRepository(@Autowired SessionFactory factory) {
        super(factory, Clinic.class);
    }

    public List<Clinic> searchByCity(String cityName){
        return new ArrayList<>();

        // return super.likeAnywhere("address.city", cityName);
    }
}
