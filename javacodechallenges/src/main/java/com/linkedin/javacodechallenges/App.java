package com.linkedin.javacodechallenges;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
        final double gallonsInCCF = 748.00;
        final double chargePerCCF = 3.90;
        final double minimumGallons = gallonsInCCF * 2;
        final double minimumCharge = 18.84;

        double total = minimumCharge;

        if (gallonsUsage > minimumGallons) {
            gallonsUsage -= minimumGallons;
            while (gallonsUsage > 0) {
                gallonsUsage -= gallonsInCCF;
                total += chargePerCCF;
            }
        }

        BigDecimal bigDecimalTotal = new BigDecimal(total);
        bigDecimalTotal = bigDecimalTotal.setScale(2, RoundingMode.HALF_EVEN);
        return bigDecimalTotal.doubleValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
