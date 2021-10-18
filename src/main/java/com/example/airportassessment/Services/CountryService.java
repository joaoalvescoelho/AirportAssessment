package com.example.airportassessment.Services;

import com.example.airportassessment.Models.Country;
import com.example.airportassessment.Reporting.AirportNameCount;
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

  public static final int SEARCH_FUZZY = 2;
  public static final int TOP_AIRPORTS = 10;

  @Autowired
  private CountryRepository countryRepository;

  public Optional<Country> findByCode(String code) {
    return countryRepository.findByCode(code);
  }
  
  public HighestAirports reportTopAirports() {
    List<AirportNameCount> topAirports = countryRepository.queryTopAirports(TOP_AIRPORTS);

    return new HighestAirports(topAirports);
  }

  public SearchCountry searchCountry(String name) {
    SearchCountry result;
    Optional<Country> countryOpt = countryRepository.findByName(name);

    if (countryOpt.isPresent()) {
      result = new SearchCountry(countryOpt);
    } else {
      List<String> suggestions = countryRepository.findByFuzzyName(name, SEARCH_FUZZY);
      result = new SearchCountry(suggestions);
    }

    return result;
  }
}
