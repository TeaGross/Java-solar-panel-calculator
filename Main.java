final int PANELS = 26;
final double PANEL_AREA = 1.7;                 // square meters per panel
final double RADIATION = 166.0;                // Wh per square meter per hour
final double EFFICIENCY = 0.20;
final double PRICE = 0.9;                       // SEK per kWh

double sunHours(int riseHour, int riseMin, int setHour, int setMin) {
    int totalSunriseMinutes = riseHour * 60 + riseMin;
    int totalSunsetMinutes = setHour * 60 + setMin;
    int totalDifference = totalSunsetMinutes - totalSunriseMinutes;

    double totalSunHours = totalDifference / 60.0;
    return totalSunHours;
}

double production(double sunHours) {
    double totalPanelArea = PANELS * PANEL_AREA;
    double productionKwh = (RADIATION * EFFICIENCY * totalPanelArea * sunHours) / 1000;
    return productionKwh;
}

double value(double productionKwh) {
    return productionKwh * PRICE;
}

boolean validDate(int month, int day) {
    if (!validMonth(month)) {
        IO.println("Error! Invalid month.");
        return false;
    } 
    
    if (!validDay(month, day)) {
        IO.println("Error! Invalid day.");
        return false;
    }
     
    return true;
}

boolean validMonth(int month) {
    return (month == 6 || month == 7);
}

boolean validDay(int month, int day) {
    if (day > 0) {
        if (month == 6 && day <= 30) {
            return true;
        } else if (month == 7 && day <= 31) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

boolean validTime(int hour, int minute) {
    if (!validHour(hour)) {
        IO.println("Error! Invalid time. Hours must be between 0 and 23.");
        return false;
    }

    if (!validMinute(minute)) {
        IO.println("Error! Invalid time. Minutes must be between 0 and 59.");
        return false;
    }
    return true;
}

boolean validHour(int hour) {
    if (hour >= 0 && hour <= 23) {
        return true;
    } else {
        return false;
    }
}

boolean validMinute (int minute) {
    if (minute >= 0 && minute <= 59) {
        return true;
    } else {
        return false;
    }
}

boolean validSunriseSunset (int sunriseHour, int sunsetHour, int sunriseMinute, int sunsetMinute) {
    int sunriseTotalMinutes = (sunriseHour * 60) + sunriseMinute;
    int sunsetTotalMinutes = (sunsetHour * 60) + sunsetMinute;

    if (sunriseTotalMinutes >= sunsetTotalMinutes) {
        IO.println("Error! Sunrise must be before sunset. ");
        return false;
    }
    return true;
}

void main() {
    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("[\\s:-]+");

    
    String formattedDate = ""; // empty declaration for formatted date. 

    IO.print("Enter today's date [mm-dd] ");

    if (!scanner.hasNextInt()) {
        IO.print("Error! Please enter numbers in the correct format. ");
        return;
    }
    
    int month = scanner.nextInt();
    int day = scanner.nextInt(); 

    if (!validDate(month, day)) {
        return;
    } 

    String formattedDay = String.format("%02d", day);
    formattedDate = formattedDay + "/" + month;

    IO.print("Enter the time of sunrise [hh:mm] ");

    if (!scanner.hasNextInt()) {
        IO.print("Error! Please enter numbers in the correct format. ");
        return;
    }

    int sunriseHour = scanner.nextInt();
    int sunriseMinute = scanner.nextInt();

    if (!validTime(sunriseHour, sunriseMinute)) {
        return;
    }

    IO.print("Enter the time of sunset [hh:mm] ");

    if (!scanner.hasNextInt()) {
        IO.print("Error! Please enter numbers in the correct format. ");
        return;
    }

    int sunsetHour = scanner.nextInt();
    int sunsetMinute = scanner.nextInt();

    if (!validTime(sunsetHour, sunsetMinute) 
        || !validSunriseSunset(sunriseHour, sunsetHour, sunriseMinute, sunsetMinute)) {
        return;
    }

    double totalSunHours = sunHours(sunriseHour, sunriseMinute, sunsetHour, sunsetMinute);
    double productionKwh = production(totalSunHours);
    double totalValue = value(productionKwh);

    IO.println("==========================================");
    IO.println("Sun hours: " + String.format("%.2f", totalSunHours) + " hours");
    IO.println("The production on " + formattedDate + " is: " + String.format("%.2f", productionKwh) 
        + " kWh to a value of: SEK " + String.format("%.2f", totalValue));
}