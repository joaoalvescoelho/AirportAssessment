package com.example.airportassessment.Reporting;

import com.example.airportassessment.Models.Country;
import java.util.Optional;

public class SearchCountry {
    private final Optional<Country> country;

    public SearchCountry(Optional<Country> country) {
        this.country = country;
    }

    public Optional<Country> getCountry() {
        return country;
    }
}

