package com.project.travel_planner_frontend;

import java.util.HashSet;
import java.util.Set;

public class FlightService {

    private Set flights;
    private static FlightService flightService;

    private FlightService() {
        this.flights = exampleData();
    }

    public static FlightService getInstance() {
        if (flightService == null) {
            flightService = new FlightService();
        }
        return flightService;
    }

    public Set getFlights() {
        return new HashSet<>(flights);
    }

    private Set exampleData() {
        Set flights = new HashSet<>();
        flights.add(new Flight("Kraków", "Warszawa", "10-12-2020" ,  "14:30"));
        flights.add(new Flight("Warszawa", "Kraków", "11-12-2020" ,  "16:30"));
        flights.add(new Flight("Londyn", "Wrocław", "12-12-2020" ,  "21:00"));
        flights.add(new Flight("Berlin", "Gdańsk", "13-12-2020" ,  "17:40"));
        flights.add(new Flight("Katowice", "Łódź", "14-12-2020" ,  "22:55"));
        return flights;
    }

    public void save(Flight flight) {
        this.flights.add(flight);
    }

    public void delete(Flight flight) {
        this.flights.remove(flight);
    }

    public void chooseFlight(Flight flight) {
        flights.contains(flight);
    }

}
