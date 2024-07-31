package com.appsdeveloperblogs.app.ws.examples;

public class JKL {
    public static void main(String[] args) {
        String[] data = {
                "3 runs (1 GB)",
                "4 runs (2 GB)",
                "6 runs (3 GB)",
                "3 runs (1 GB)",
                "1 runs (50 MB)",
                "2 runs (100 MB)",
                "3 runs (1 GB)",
                "4 runs (2 GB)",
                "1 runs (50 MB)",
                "2 runs (100 MB)"
        };

        int totalRuns = 0;

        // Iterate through each line of data
        for (String line : data) {
            // Split the line by space to extract the number of runs
            String[] parts = line.split("\\s+");

            // Extract the number of runs (it's the first element in the split array)
            int runs = Integer.parseInt(parts[0]);

            // Add to the total number of runs
            totalRuns += runs;
        }

        // Output the total number of runs
        System.out.println("Total number of runs: " + totalRuns);
    }
}
