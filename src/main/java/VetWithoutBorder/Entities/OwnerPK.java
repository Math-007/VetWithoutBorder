package VetWithoutBorder.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerPK implements Serializable {

    @Id
    @Column(name = "propNo")
    private String ownerNo;

    @Id
    @Column(name = "cliniqueNo")
    private String clinicNo;
}
