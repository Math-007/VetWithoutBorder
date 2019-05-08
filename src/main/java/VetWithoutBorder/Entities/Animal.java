package VetWithoutBorder.Entities;

import lombok.*;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.sql.Date;

@Converter
class TimeConverter implements AttributeConverter<String, Date> {

    @Override
    public Date convertToDatabaseColumn(String attribute) {
        return Date.valueOf(attribute);
    }

    @Override
    public String convertToEntityAttribute(Date dbData) {
        return dbData.toString();
    }
}

@Entity
@Embeddable
@Table(name= "Animal")
@IdClass(AnimalPK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @SequenceGenerator(name="pk_sequence", sequenceName="animal_animalno_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="pk_sequence")
    @Column(name="animalno", insertable = false, updatable = false)
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

    @Column(name = "dateInscription", insertable = false, updatable = false)
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Convert(converter = TimeConverter.class)
    private Date inscriptionDate;

    @Column(name = "dateNaissance")
    //@Convert(converter = TimeConverter.class)
    private Date dateOfBirth;

    @Column(name = "etatActuel")
    private String state;

    public String toString() {
        return "nom : " + this.name;
    }
}
