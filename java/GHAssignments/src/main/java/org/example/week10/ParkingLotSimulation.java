package org.example.week10;

import java.util.concurrent.Semaphore;

public class ParkingLotSimulation {
    public static void main(String[] args) {
        int parkingSpots = 5; // Number of parking spots
        Semaphore semaphore = new Semaphore(parkingSpots); // Semaphore with 5 permits

        for (int i = 1; i <= 10; i++) { // Simulate 10 cars
            final int carNumber = i;
            new Thread(() -> {
                try {
                    System.out.println("Car " + carNumber + " is waiting to park.");
                    semaphore.acquire(); // Wait for a spot
                    System.out.println("Car " + carNumber + " has parked.");
                    Thread.sleep((long) (Math.random() * 5000)); // Park for a random time
                    System.out.println("Car " + carNumber + " is leaving the parking lot.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // Leave the spot
                }
            }).start();
        }
    }
}
