package application;

public class StandardSensor implements Sensor {

    private int number;

    public StandardSensor(int number) {
        this.number = number;
    }

    // returns true if the sensor is on
    public boolean isOn() {
        return true;
    }

    // sets the sensor on
    public void setOn() {
    }

    // sets the sensor off
    public void setOff() {
    }

    public int read() {
        return this.number;
    }
}
