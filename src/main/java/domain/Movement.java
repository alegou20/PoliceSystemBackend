package domain;

import gateway.IMessage;
import java.awt.*;

public class Movement implements IMessage {

    private Long id;
    private String serialNumber;
    private Point coord = new Point();

    public Movement() {
    }

    public Movement(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Point getCoord() {
        return coord;
    }

    public void setCoord(Point coord) {
        this.coord = coord;
    }

    @Override
    public String getCommaSeperatedValue() {
        return id + "," + serialNumber + "," + "," + coord.getX() + "," + coord.getY();
    }

    @Override
    public void fillFromCommaSeperatedValue(String value) {

        System.out.println("1: " + value);

        String[] array = value.split(",");

        System.out.println("2: " + array.toString());

        if (array.length != 4)
            throw new IllegalArgumentException();

        id = Long.valueOf(array[0]);
        serialNumber = array[1];

        System.out.println("Sanidirect " + Double.parseDouble(array[3]));

        coord.setLocation(Double.parseDouble(array[3]), Double.parseDouble(array[4]));
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", coord=" + coord +
                '}';
    }
}
