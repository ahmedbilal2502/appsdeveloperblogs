package com.appsdeveloperblogs.app.ws.examples;

public class Vlaidat {
    public static void main(String[] args) {
        System.out.println(String.format("%02d", 10 + 1));


        System.out.println(convertToMB("50 GB"));
        System.out.println(convertToMB("50 MB"));

        System.out.println(convertToMB("1 GB"));

    }
    private static String convertToMB(String reward) {
        if (reward == null || reward.isEmpty()) {
            return "0";
        }

        String[] parts = reward.split(" ");
        if (parts.length != 2) {
            return "0";
        }

        try {
            double value = Double.parseDouble(parts[0]);
            String unit = parts[1].toUpperCase();

            if ("GB".equals(unit)) {
                value = value * 1024; // Convert GB to MB
            } else if (!"MB".equals(unit)) {
                return "0"; // Invalid unit
            }

            return String.format("%.0f", value); // Store as MB without decimal points
        } catch (NumberFormatException e) {
            return "0"; // Handle invalid number format
        }
    }

    private static String convertToGB(String totalClaimReward) {
        if (totalClaimReward == null || totalClaimReward.isEmpty()) {
            return "0 GB";
        }

        String[] parts = totalClaimReward.split(" ");
        if (parts.length != 2) {
            return "0 GB";
        }

        try {
            double value = Double.parseDouble(parts[0]);
            String unit = parts[1].toUpperCase();

            if ("MB".equalsIgnoreCase(unit)) {
                value = value / 1024; // Convert MB to GB
            } else if (!"GB".equals(unit)) {
                return "0 GB"; // Invalid unit
            }

            return String.format("%.2f", value) + " GB";
        } catch (NumberFormatException e) {
            return "0 GB"; // Handle invalid number format
        }
    }
}
