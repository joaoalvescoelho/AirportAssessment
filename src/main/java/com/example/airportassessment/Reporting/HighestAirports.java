package com.example.airportassessment.Reporting;

import java.util.List;

public class HighestAirports {

  private final List<AirportNameCount> top;

  public HighestAirports(List<AirportNameCount> top) {
    this.top = top;
  }

  public List<AirportNameCount> getTop() {
    return top;
  }

}
