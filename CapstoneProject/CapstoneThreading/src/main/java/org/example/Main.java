package org.example;

public class Main {
    public static void main(String[] args) {
        int threadCount = 1000; // Number of threads to create
        Thread[] threads = new Thread[threadCount]; // Array to store each thread
        int[] totals = new int[threadCount]; // Array to store each thread's computed sum
        long startTime = System.currentTimeMillis(); // Record the start time of execution

        // Create and start each thread
        for (int i = 0; i < threadCount; i++) {
            final int index = i; // Capture the index for thread access in the run method
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int sum = 0; // Variable to store the sum of numbers from 1 to 1000
                    for (int j = 1; j <= 1000; j++) {
                        sum += j; // Calculate sum of numbers from 1 to 1000
                    }
                    totals[index] = sum; // Store the sum in the corresponding index of totals array
                    System.out.println("Thread " + Thread.currentThread().getId() + " is running."); // Print thread ID
                }
            });
            threads[i].start(); // Start the thread
        }

        // Ensure each thread completes before moving on
        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join(); // Wait for each thread to complete
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle any interruptions
            }
        }

        int Total = 0; // Variable to store the grand total of all thread sums
        // Sum up all totals from each thread
        for (int i = 0; i < threadCount; i++) {
            Total += totals[i]; // Add each thread's sum to the grand total
        }

        long endTime = System.currentTimeMillis(); // Record the end time of execution
        long duration = endTime - startTime; // Calculate the total execution time

        // Print the results
        System.out.println("Total of all thread sums: " + Total); // Print the grand total of sums
        System.out.println("Program execution time: " + duration + " milliseconds"); // Print the duration in milliseconds

        System.out.println("Total of all thread sums: " + Total); // Duplicate print statement for the total
    }
}
