package VetWithoutBorder.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
class Address {

    @Column(name = "province")
    private String province;

    @Column(name = "codePostal")
    private String postalCode;

    @Column(name = "rue")
    private String street;

    @Column(name = "ville")
    private String city;
}
