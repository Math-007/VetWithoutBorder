package VetWithoutBorder.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalPK implements Serializable {
    @Column(name = "animalNo")
    private Integer animalNo;
    @Column(name = "cliniqueNo")
    private String clinicNo;

/*    protected final boolean equals_(Animal obj)
    {
        // Comparer les attributs
        return obj.getAnimalNo().equals(this.animalNo) && obj.getClinicNo()
    }


    public boolean equals(Object o){
        if ((o != null) && (o.getClass() == Animal.class))
        {
            return equals_((Animal)o);
        }
        return false;
    }*/
}
