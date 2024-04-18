package review.collectionTest;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeExam2 {
    public static void main(String[] args) {
        // Define the time zones for both countries
        String myCountryTimeZone = "America/New_York";  // Example: New York
        String anotherCountryTimeZone = "Europe/Paris"; // Example: Paris

        // Get the current time in each time zone
        ZonedDateTime myCountryTime = ZonedDateTime.now(ZoneId.of(myCountryTimeZone));
        ZonedDateTime anotherCountryTime = ZonedDateTime.now(ZoneId.of(anotherCountryTimeZone));

        // Calculate the duration between times
        Duration duration = Duration.between(myCountryTime, anotherCountryTime);

        // Get the absolute difference in hours (ignoring day differences)
        long hoursDifference = Math.abs(duration.toHours());

        // Output the difference
        System.out.printf("The time difference between %s and %s is %d hours.\n",
                myCountryTimeZone, anotherCountryTimeZone, hoursDifference);
    }
}
