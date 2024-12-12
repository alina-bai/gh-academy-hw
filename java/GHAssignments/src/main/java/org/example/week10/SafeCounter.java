package org.example.week10;

import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {
    private int count = 0; // The counter
    private final ReentrantLock lock = new ReentrantLock(); // Lock to ensure thread safety

    public void increment() {
        lock.lock(); // Lock before modifying count
        try {
            count++;
            System.out.println("Count incremented to: " + count);
        } finally {
            lock.unlock(); // Unlock after modification
        }
    }

    public void decrement() {
        lock.lock(); // Lock before modifying count
        try {
            count--;
            System.out.println("Count decremented to: " + count);
        } finally {
            lock.unlock(); // Unlock after modification
        }
    }

    public int getValue() {
        lock.lock(); // Lock before reading count
        try {
            return count;
        } finally {
            lock.unlock(); // Unlock after reading
        }
    }

    public static void main(String[] args) {
        SafeCounter counter = new SafeCounter();

        // Create threads to increment and decrement the counter
        for (int i = 0; i < 5; i++) {
            new Thread(counter::increment).start();
            new Thread(counter::decrement).start();
        }
    }
}
