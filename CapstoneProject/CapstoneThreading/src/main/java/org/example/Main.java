package org.example;

public class Main {
    public static void main(String[] args) {
        int threadCount = 1000;
        Thread[] threads = new Thread[threadCount];
        int[] totals = new int[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int index =i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int sum = 0;
                    for(int j=1; j<=1000; j++)
                        sum += j;
                    totals[index] = sum;
                    System.out.println("Thread " + Thread.currentThread().getId() + " is running.");
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int Total = 0;
        for (int i = 0; i < threadCount; i++) {
            Total += totals[i];
        }

        System.out.println("Total of all thread sums: " + Total);
    }
}