package VetWithoutBorder.Entities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AnimalPK implements Serializable {

    private Integer animalNo;
    private String clinicNo;
}
