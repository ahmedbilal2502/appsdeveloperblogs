package com.appsdeveloperblogs.app.ws.examples;

public class MaximumSubarraySum {

    public static int maxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Update the current sum to either include the current element or start a new subarray
            System.out.println("Current sum "+currentSum+" "+nums[i]);

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            System.out.println("Current sum "+currentSum);
            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
            System.out.println("maxSum "+maxSum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubarraySum(nums);
        System.out.println("Maximum sum of a contiguous subarray: " + maxSum);
    }
}

