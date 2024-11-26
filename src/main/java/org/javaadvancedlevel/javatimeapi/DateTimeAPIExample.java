package org.javaadvancedlevel.javatimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIExample {

    /**
     * Demonstrates the usage of LocalDate, LocalTime, and LocalDateTime classes.
     * LocalDate: Represents a date without time.
     * LocalTime: Represents a time without date.
     * LocalDateTime: Represents both date and time.
     * All these classes are immutable and thread-safe.
     * They provide various methods for date and time manipulation.
     *
     */
    /**
     * LocalDate, LocalTime, and LocalDateTime classes for representing date and time.
     * Period and Duration for time manipulation.
     * DateTimeFormatter for parsing and formatting dates.
     * ZonedDateTime for handling time zones
     */
    public static void demonstrateLocalDateTime() {
        // Current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentDateTime);
    }

    /**
     * Demonstrates the usage of Period and Duration for time manipulation.
     */
    public static void demonstratePeriodAndDuration() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        // Period between two dates
        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period);

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);

        // Duration between two times
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration: " + duration);
    }

    /**
     * Demonstrates the usage of DateTimeFormatter for parsing and formatting.
     */
    public static void demonstrateDateTimeFormatter() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Formatting date
        String formattedDate = date.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);

        // Parsing date
        LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
        System.out.println("Parsed Date: " + parsedDate);
    }

    /**
     * Demonstrates the usage of ZonedDateTime for time zones.
     */
    public static void demonstrateZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + zonedDateTime);

        // Specific time zone
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York Time: " + newYorkTime);
    }
    public static void demonstrateTimeZones() {
        // GMT: Greenwich Mean Time
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("GMT Time: " + gmtTime);

        // UTC: Coordinated Universal Time
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("UTC Time: " + utcTime);

        // EST: Eastern Standard Time
        ZonedDateTime estTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("EST Time: " + estTime);

        // CST: Central Standard Time
        ZonedDateTime cstTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("CST Time: " + cstTime);

        // IST: Indian Standard Time
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("IST Time: " + istTime);

        // JST: Japan Standard Time
        ZonedDateTime jstTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("JST Time: " + jstTime);

        // AEST: Australian Eastern Standard Time
        ZonedDateTime aestTime = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println("AEST Time: " + aestTime);

        // BST: British Summer Time
        ZonedDateTime bstTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println("BST Time: " + bstTime);

        // CEST: Central European Summer Time
        ZonedDateTime cestTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("CEST Time: " + cestTime);

        // EAT: East Africa Time
        ZonedDateTime eatTime = ZonedDateTime.now(ZoneId.of("Africa/Nairobi"));
        System.out.println("EAT Time: " + eatTime);

        // MSK: Moscow Standard Time
        ZonedDateTime mskTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        System.out.println("MSK Time: " + mskTime);
    }




    public static void main(String[] args) {
        demonstrateLocalDateTime();
        demonstratePeriodAndDuration();
        demonstrateDateTimeFormatter();
        demonstrateZonedDateTime();
        demonstrateTimeZones();
    }
}
