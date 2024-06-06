package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean state;

    public TemperatureSensor() {
        this.state = false;
    }

    // returns true if the sensor is on
    public boolean isOn() {
        return this.state;
    }

    // sets the sensor on
    public void setOn() {
        this.state = true;
    }

    // sets the sensor off
    public void setOff() {
        this.state = false;
    }

    // returns the value of the sensor if it's on
    // if the sensor is not on throw a IllegalStateException
    public int read() {
        if (this.state == false) {
            throw new IllegalStateException();
        }
        return new Random().nextInt(61) - 30;
    }
}
