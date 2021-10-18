package com.example.airportassessment.Reporting;

import com.example.airportassessment.Models.Country;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SearchCountry {
    private final Optional<Country> country;
    private final List<String> fuzzySuggestion;

    public SearchCountry(Optional<Country> country) {
        this.country = country;
        this.fuzzySuggestion = Collections.emptyList();
    }

    public SearchCountry(List<String> fuzzySuggestion) {
        this.fuzzySuggestion = fuzzySuggestion;
        this.country = Optional.empty();
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public List<String> getFuzzySuggestion() {
        return fuzzySuggestion;
    }
}

