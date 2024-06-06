package FlightControl.logic;

import java.util.Collection;
import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import java.util.HashMap;
import java.util.Map;
import FlightControl.domain.Place;

public class FlightControl {
    private Map<String, Airplane> airplanes;
    private Map<String, Flight> flights;
    private Map<String, Place> places;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addAirplane(String id, int capacity) {
        Airplane airplane = new Airplane(id, capacity);
        this.airplanes.put(id, airplane);
    }

    public void addFlight(Airplane airplane, String departureID, String destinationID) {
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));

        Flight flight = new Flight(airplane, this.places.get(departureID), this.places.get(destinationID));
        this.flights.put(flight.toString(), flight);
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Airplane getAirplane(String id) {
        return this.airplanes.get(id);
    }
}