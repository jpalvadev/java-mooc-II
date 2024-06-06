package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private Place departure;
    private Place destination;

    public Flight(Airplane airplane, Place departure, Place destination) {
        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public Place getDeparture() {
        return this.departure;
    }

    public Place getDestination() {
        return this.destination;
    }

    public String toString() {
        return this.airplane.toString() + " (" + this.departure.toString() + "-" + this.destination.toString() + ")";
    }
}