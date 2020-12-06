package com.project.travel_planner_frontend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {
    private String flightStartingPoint;
    private String flightDirection;
    private String flightDate;
    private String flightTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightDirection.equals(flight.flightDirection) &&
                flightDate.equals(flight.flightDate) &&
                flightTime.equals(flight.flightTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDirection, flightDate, flightTime);
    }
}
