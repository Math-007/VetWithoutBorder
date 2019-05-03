package VetWithoutBorder.Entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Embeddable
@Table(name= "Animal")
@IdClass(AnimalPK.class)
public class Animal {
    @Id
    @Column(name = "animalNo")
    private Integer animalNo;

    @Id
    @Column(name = "cliniqueNo")
    private String clinicNo;

    @Column(name = "propNo")
    private String ownerNo;

    @Column(name = "nom")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "dateInscription")
    private String inscriptionDate;

    @Column(name = "dateNaissance")
    private String dateOfBirth;

    @Column(name = "etatActuel")
    private String state;

    public String toString() {
        return "nom : " + this.name;
    }
}
