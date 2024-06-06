package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    // returns true if ALL sensors are ON
    public boolean isOn() {
        return this.sensors.stream().allMatch(sensor -> sensor.isOn());
    }

    // sets ALL sensors ON
    public void setOn() {
        this.sensors.stream().forEach(Sensor::setOn);
    }

    // sets ALL sensors OFF
    public void setOff() {
        this.sensors.stream().forEach(Sensor::setOff);
    }

    public int read() {
        if (!(this.isOn()) || this.sensors.isEmpty()) {
            throw new IllegalStateException();
        }

        int totalTemp = this.sensors.stream()
                .map(sensor -> sensor.read())
                .reduce(0, (total, currTemp) -> total + currTemp);

        int averageTemp = totalTemp / this.sensors.size();
        this.readings.add(averageTemp);
        return averageTemp;
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readings;

    }
}
