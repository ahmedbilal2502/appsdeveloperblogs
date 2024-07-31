package com.appsdeveloperblogs.app.ws.examples;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
public class UcloudService {
    private static final int MAX_RETRIES = 5;
    private static ScheduledExecutorService scheduler;

    public static CompletableFuture<UcloudResponse> callUcloudFunctionWithRetry() {
        scheduler=Executors.newScheduledThreadPool(1);
        CompletableFuture<UcloudResponse> ucloudResponseCompletableFuture= callUcloudFunctionWithRetry(0);
        ucloudResponseCompletableFuture.join();
        scheduler.shutdown();
        return ucloudResponseCompletableFuture;
    }

    private static CompletableFuture<UcloudResponse> callUcloudFunctionWithRetry(int retryCount) {
        System.out.println("retry Count "+retryCount);
        return CompletableFuture.supplyAsync(() -> {
            // Simulate calling the Ucloud function
            UcloudResponse response = callUcloudFunction();
            return response;
        }).thenCompose(response -> {
            if ("435".equals(response.getResponseCode()) || retryCount >= MAX_RETRIES) {
                return CompletableFuture.completedFuture(response);
            } else {
                return delayedRetry(retryCount + 1);
            }
        });
    }

    private static CompletableFuture<UcloudResponse> delayedRetry(int retryCount) {
        CompletableFuture<UcloudResponse> delayedFuture = new CompletableFuture<>();
        scheduler.schedule(() -> {
            callUcloudFunctionWithRetry(retryCount).whenComplete((result, throwable) -> {
                if (throwable != null) {
                    delayedFuture.completeExceptionally(throwable);
                } else {
                    delayedFuture.complete(result);
                }
            });
        }, 100, TimeUnit.MILLISECONDS); // Delay between retries, adjust as needed
        return delayedFuture;
    }

    private static UcloudResponse callUcloudFunction() {
        // Simulate the function call, should be replaced with actual implementation
        UcloudResponse response = new UcloudResponse();
        // Here you would have the actual logic to call the Ucloud API
        // For this example, we simulate a random response code
        double random = Math.random();
        if (random < 400) {
            response.setResponseCode("200");
            response.setResponseDesc("Success");
        } else {
            response.setResponseCode("500");
            response.setResponseDesc("Error occurred");
        }
        return response;
    }

    public static void main(String[] args) {

        CompletableFuture<UcloudResponse> callUcloudFunctionWithRetry=callUcloudFunctionWithRetry();

     /*   callUcloudFunctionWithRetry().thenAccept(response -> {
            System.out.println("Final response code: " + response.getResponseCode());
            System.out.println("Response description: " + response.getResponseDesc());
        }).exceptionally(throwable -> {
            System.err.println("Failed to get a successful response: " + throwable.getMessage());
            return null;
        });*/
    }
}