package VetWithoutBorder.Entities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OwnerPK implements Serializable {

    private String ownerNo;
    private String clinicNo;
}
