package com.example.airportassessment.Repositories;

import com.example.airportassessment.Models.Airport;
import com.example.airportassessment.Models.Country;
import com.example.airportassessment.Reporting.AirportNameCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

  Optional<Country> findByCode(String code);
  Optional<Country> findByName(String name);

  @Query(
      value = "SELECT name FROM countries c WHERE levenshtein(c.name, ?1) < ?2",
      nativeQuery = true)
  List<Airport> findByFuzzyName(String name, int likeliness);

  @Query(
      value = "SELECT c.name as name, count(*) as count " +
              "FROM countries c INNER JOIN airports a ON c.code = a.iso_country " +
              "GROUP BY c.name ORDER BY count DESC LIMIT ?1",
      nativeQuery = true)
  List<AirportNameCount> queryTopAirports(int limit);

}
