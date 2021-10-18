package com.example.airportassessment.Services;

import com.example.airportassessment.Models.Airport;
import com.example.airportassessment.Models.Country;
import com.example.airportassessment.Reporting.AirportNameCount;
import com.example.airportassessment.Reporting.FuzzySearch;
import com.example.airportassessment.Reporting.HighestAirports;
import com.example.airportassessment.Reporting.SearchCountry;
import com.example.airportassessment.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

  public static final int TOP_AIRPORTS = 10;
  public static final int FUZZY_NAME= 4;

  @Autowired
  private CountryRepository countryRepository;

  public HighestAirports reportTopAirports() {
    List<AirportNameCount> topAirports = countryRepository.queryTopAirports(TOP_AIRPORTS);

    return new HighestAirports(topAirports);
  }

   public FuzzySearch searchCountryByFuzzy(String name) {
     List<Airport> fuzzyList = countryRepository.findByFuzzyName(name, FUZZY_NAME);

     return new FuzzySearch(fuzzyList);
  }

  public SearchCountry searchCountry(String name) {
    SearchCountry result;
    Optional<Country> countryOptName = countryRepository.findByName(name);

    if (countryOptName.isPresent()) {
      result = new SearchCountry(countryOptName);
    } else {
      Optional<Country> countryOptCode = countryRepository.findByCode(name);
      result = new SearchCountry(countryOptCode);
    }
    return result;
  }
}
