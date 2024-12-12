package org.example.week10;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
        System.out.println("Added: " + key + " -> " + value);
    }

    public String get(String key) {
        String value = map.get(key);
        System.out.println("Retrieved: " + key + " -> " + value);
        return value;
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

        // Writer threads
        for (int i = 1; i <= 3; i++) {
            final int threadId = i;
            new Thread(() -> cache.put("key" + threadId, "value" + threadId)).start();
        }

        // Reader threads
        for (int i = 1; i <= 3; i++) {
            final int threadId = i;
            new Thread(() -> cache.get("key" + threadId)).start();
        }
    }
}