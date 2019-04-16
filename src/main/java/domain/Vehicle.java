package domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.getById", query = "select v from Vehicle v where v.id = :id"),
        @NamedQuery(name = "Vehicle.getAll", query = "select v from Vehicle v")
})
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String licencePlate;

    @OneToMany(targetEntity = Cartracker.class, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cartracker> carTrackers = new ArrayList();

    @OneToMany(targetEntity = OwnerCredentials.class, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OwnerCredentials> ownerCredentials = new ArrayList();

    public Vehicle() {
    }

    public Vehicle(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public List getOwnerCredentials() {
        return ownerCredentials;
    }

    public void setOwnerCredentials(List ownerCredentials) {
        this.ownerCredentials = ownerCredentials;
    }


    public List getCarTrackers() {
        return carTrackers;
    }


    public void setCarTrackers(List carTrackers) {
        this.carTrackers = carTrackers;
    }
}
