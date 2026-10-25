# Solar Panel Calculator :tada:

This project was developed as part of an introductory Java programming course. It focuses on fundamental programming concepts such as methods, input validation, and calculations.

A Java program that estimates the electricity production and monetary value of 26 solar panels based on the hours between sunrise and sunset.

The program takes a date, sunrise time, and sunset time as input. It validates the input and calculates the estimated energy production in kilowatt-hours (kWh) and its value in Swedish kronor (SEK).

## Features :sparkles:

- Calculates daylight hours from sunrise and sunset times

- Estimates solar energy production in kWh

- Calculates the monetary value of the generated electricity

- Validates dates and times, including invalid input formats

- Formats numerical results to two decimal places

## Calculation :pencil2:

The program uses the following fixed values:

Number of panels: 26

Area per panel: 1.7 m²

Solar radiation: 166 Wh/m²/hour

Panel efficiency: 20%

Electricity price: 0.9 SEK/kWh

Energy production is calculated using the total panel area, solar radiation, panel efficiency, and hours of sunshine. The result is converted from watt-hours to kilowatt-hours before calculating its monetary value.

## Example

#### Enter today's date [mm-dd] 06-22
#### Enter the time of sunrise [hh:mm] 01:46
#### Enter the time of sunset [hh:mm] 23:28
----------------------------------------
#### Sun hours: 21.70 hours
#### The production on 22/6 is: 31.84 kWh to a value of: SEK 28.66

## Concepts Practiced

- Java methods and return values

- Constants and variables

- Conditional logic and input validation

- Reading input with Scanner and useDelimiter

- Working with numerical calculations and double

- String formatting with String.format

## Technologies
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
