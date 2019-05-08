package VetWithoutBorder.Database;

import VetWithoutBorder.Entities.Owner;
import VetWithoutBorder.Entities.OwnerPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Transactional
@Repository
public class OwnerRepository extends AbstractRepository<Owner, OwnerPK> {

    OwnerRepository(@Autowired SessionFactory factory) {
        super(factory, Owner.class);
    }

    public List<Owner> searchByClinicNo(String clinicNo) {
        return super.where("clinicNo", clinicNo);
    }

    public List<Owner> searchByOwnerName(String firstName, String lastName) {
        List<Owner> first = super.likeAnywhere("firstName", firstName);
        List<Owner> last = super.likeAnywhere("lastName", lastName);

        Collection<Owner> set = new HashSet<>();

        set.addAll(first);
        set.addAll(last);

        return new ArrayList<>(set);
    }
}
