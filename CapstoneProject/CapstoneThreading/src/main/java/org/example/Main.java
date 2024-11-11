package org.example;

public class Main {
    public static void main(String[] args) {
        int threadCount = 1000;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is running.");
                }
            });
            threads[i].start();
        }
    }
}