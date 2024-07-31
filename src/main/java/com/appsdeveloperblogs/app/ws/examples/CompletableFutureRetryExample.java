package com.appsdeveloperblogs.app.ws.examples;

import java.util.concurrent.*;

public class CompletableFutureRetryExample {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final int MAX_RETRIES = 6;

    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseService();
        String data = "Some important data";
        System.out.println(data);

        CompletableFuture<Boolean> saveFuture = saveWithRetry(dbService, data, 0);

        try {
            boolean result = saveFuture.join();
            if (result) {
                System.out.println("Data saved successfully!");
            } else {
                System.out.println("Failed to save data after retries.");
            }
        } catch (CompletionException e) {
            System.out.println("Failed to save data: " + e.getCause().getMessage());
        }
        scheduler.shutdown();

    }

    private static CompletableFuture<Boolean> saveWithRetry(DatabaseService dbService, String data, int attempt) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                dbService.saveData(data);
                return true;
            } catch (Exception e) {
                System.out.println("Attempt " + (attempt + 1) + " failed: " + e.getMessage());
                return false;
            }
        }).thenCompose(success -> {
            if (success) {
                return CompletableFuture.completedFuture(true);
            } else if (attempt < MAX_RETRIES - 1) {
                CompletableFuture<Boolean> retryFuture = new CompletableFuture<>();
                scheduler.schedule(() -> {
                    saveWithRetry(dbService, data, attempt + 1).thenAccept(retryFuture::complete);
                }, 4, TimeUnit.SECONDS); // Retry delay
                return retryFuture;
            } else {
                return CompletableFuture.completedFuture(false);
            }
        });
    }
}

class DatabaseService {
    public void saveData(String data) throws Exception {
        // Simulate a 50% chance of failure
        if (Math.random() < 0.5) {
            throw new Exception("Simulated database failure");
        }
        // Simulate saving data to the database
        System.out.println("Data saved: " + data);
    }
}
