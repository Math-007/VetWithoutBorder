package VetWithoutBorder.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Embeddable
@Table(name= "Proprietaire")
@IdClass(OwnerPK.class)
public class Owner {

    @Id
    @Column(name = "propNo")
    private String ownerNo;

    @Id
    @Column(name = "cliniqueNo")
    private String clinicNo;

    @Column(name = "prenom")
    private String firstName;

    @Column(name = "nom")
    private String lastName;

    @Column(name = "numTelephone")
    private String phoneNumber;

    @Embedded()
    private Address address;
}
