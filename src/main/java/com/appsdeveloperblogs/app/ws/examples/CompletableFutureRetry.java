package com.appsdeveloperblogs.app.ws.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureRetry {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        try {
            String result = retry(() -> unreliableOperation(), 3, 1000).get();
            System.out.println("Operation result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            scheduler.shutdown();
        }
    }

    public static CompletableFuture<String> unreliableOperation() {
        return CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 1000) {
                System.out.println("Failed" );
            }
            return "Success";
        });
    }

    public static <T> CompletableFuture<T> retry(Supplier<CompletableFuture<T>> operation, int retries, long delayMillis) {
        CompletableFuture<T> promise = new CompletableFuture<>();
        retry(operation, retries, delayMillis, promise);
        return promise;
    }

    private static <T> void retry(Supplier<CompletableFuture<T>> operation, int retries, long delayMillis, CompletableFuture<T> promise) {
        operation.get().whenComplete((result, throwable) -> {
            if (throwable == null) {
                promise.complete(result);
            } else if (retries > 0) {
                scheduler.schedule(() -> retry(operation, retries - 1, delayMillis, promise), delayMillis, TimeUnit.MILLISECONDS);
            } else {
                promise.completeExceptionally(throwable);
            }
        });
    }
}
