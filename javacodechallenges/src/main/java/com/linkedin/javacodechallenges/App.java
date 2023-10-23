package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.ZoneId;

public class App {
    // Create function to calculate the date that's
    // 100 days from now

    public static LocalDate hundredDaysFromNow(LocalDate date) {
        final int daysIntoFuture = 100;
        return date.plusDays(daysIntoFuture);
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("100 days from now is... " + hundredDaysFromNow(date));
    }
}
