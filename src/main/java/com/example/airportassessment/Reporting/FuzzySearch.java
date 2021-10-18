package com.example.airportassessment.Reporting;

import com.example.airportassessment.Models.Airport;

import java.util.List;

public class FuzzySearch {

    private final List<Airport> airports;

    public FuzzySearch(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Airport> getAirports() {
        return airports;
    }
}
