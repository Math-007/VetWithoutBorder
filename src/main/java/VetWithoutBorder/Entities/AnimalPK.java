package VetWithoutBorder.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalPK implements Serializable {

    @Column(name = "animalNo")
    private Integer animalNo;

    @Column(name = "cliniqueNo")
    private String clinicNo;
}
