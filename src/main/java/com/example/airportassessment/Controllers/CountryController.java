package com.example.airportassessment.Controllers;

import com.example.airportassessment.Reporting.FuzzySearch;
import com.example.airportassessment.Reporting.HighestAirports;
import com.example.airportassessment.Reporting.SearchCountry;
import com.example.airportassessment.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

  @Autowired
  private CountryService service;

  @GetMapping("/country")
  public String country(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    SearchCountry searchResult = service.searchCountry(name);
    if (searchResult.getCountry().isPresent()) {
      model.addAttribute("country", searchResult.getCountry().get());
    } /*else {
      FuzzySearch fuzzySearch = service.searchCountryByFuzzy(name);
      model.addAttribute("fuzzyCountry", searchResult);
    }*/
    return "countries";
  }

  @GetMapping("/airport")
  public String reports(Model model) {
    HighestAirports searchResult = service.reportTopAirports();

    model.addAttribute("reportHighestAirports", searchResult);

    return "airports";
  }
}
