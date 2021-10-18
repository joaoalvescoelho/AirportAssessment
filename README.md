# AirportAssessmentChallenge
# Developer Assessment

##Description
The assessment comes with 3 CSV files. The files contain data for countries, airports and runways.

Write a program that retrieves the following information given the provided files:
- Runways for each airport given a country code or country name. 
- Top 10 countries with highest number of airports.

Bonus: Support retrieving the information given a partial/fuzzy country code/name as input parameter, e.g. entering 'zimb' will result in 'Zimbabwe'. 

##Requirements
- The program should be written in Java.
- Write production-ready code.
- Document how to run the application.
- Publish the source code into GitHub (using your own personal account) and share it with us.

**_Disclaimer: The data files in this repo have been extracted from https://openflights.org/data.html. Accenture claims no ownership or responsibility to this data or its usage._**


#INSTRUCTIONS
# Airport Service Application

## Database
Used mysql as DB, you can find the db script under /databgase/database.sql to build the db;

## Services
This application is build to meet the following cases:
1) List all airports for given country or code
2) Countries having highest number of airports

## How to run
You can run the application by launching the springboot.
After, the application should be available.
- http://localhost:8080/index.html returns the index page from where you can access two other pages.
- http://localhost:8080/country returns the page to search for airports in different countries.
- http://localhost:8080/airport returns the page with the list of top 10 countries with most airports.
