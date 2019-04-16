package domain;

import gateway.IMessage;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "CarTracker.getById", query = "select ct from CarTracker ct where ct.id = :id"),
        @NamedQuery(name = "CarTracker.getAll", query = "select ct from CarTracker ct")
})
@Table(name = "cartrackers")
public class Cartracker implements Serializable, IMessage {

    @Id
    @GeneratedValue
    private Long id;

    private int mileage;

    private String hardware;

    private boolean isDeleted;

    public Cartracker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "CarTracker{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", hardware='" + hardware + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public String getCommaSeperatedValue() {
        return id + "," + mileage;
    }

    @Override
    public void fillFromCommaSeperatedValue(String value) {
        String[] array = value.split(",", 2);
        if (array.length != 2)
            throw new IllegalArgumentException();

        id = Long.valueOf( array[0] );
        mileage = Integer.parseInt( (array[1]) );

        System.out.println("CARTRACKER ID: "+ id + " - MILEAGE: " +mileage);
    }
}
