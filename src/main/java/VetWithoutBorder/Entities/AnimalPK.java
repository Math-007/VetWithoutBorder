package VetWithoutBorder.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalPK implements Serializable {
/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalNo", updatable = false)*/
    private Integer animalNo;
/*    @Column(name = "cliniqueNo")*/
    private String clinicNo;

    public void setAnimalNo(Integer animalNo) {
        this.animalNo = animalNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo;
    }
}
