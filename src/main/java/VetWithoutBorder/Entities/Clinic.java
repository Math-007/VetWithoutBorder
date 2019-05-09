package VetWithoutBorder.Entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Embeddable
@Table(name= "Clinique")
public class Clinic {

    @Id
    @Column(name = "cliniqueNo")
    private String clinicNo;

    @Column(name = "numTelecopieur")
    private String faxNumber;

    @Column(name = "numTelephone")
    private String phoneNumber;

    @Embedded()
    private Address address;
}
