package com.example.servlets;

public class Utils {
    public static double calculateCompoundInterest(double principalAmount, double interest, int years, int compoundingPeriod) {
        return Math.round(principalAmount * Math.pow(
                        (1 + (interest / compoundingPeriod)),
                        (compoundingPeriod * years)
                )
        );
    }
}
