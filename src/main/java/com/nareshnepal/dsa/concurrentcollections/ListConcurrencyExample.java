package com.nareshnepal.dsa.concurrentcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListConcurrencyExample {

    public static void main(String[] args) {
        System.out.println("=== Using ArrayList ===");
        try {
            useArrayList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=== Using ArrayList 2 ===");
        try {
            useArrayList2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Using CopyOnWriteArrayList ===");
        useCopyOnWriteArrayList();
    }

    // ❌ Fails due to ConcurrentModificationException
    private static void useArrayList() {
        List<String> listeners = new ArrayList<>();
        listeners.add("Listener1");
        listeners.add("Listener2");

        // Thread simulating event notification
        Thread notifier = new Thread(() -> {
            for (String listener : listeners) {
                System.out.println("Notifying: " + listener);
                if (listener.equals("Listener1")) {
                    listeners.remove("Listener2"); // Fails here
                }
            }
        });

        notifier.start();
        try {
            notifier.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ✅ Safe due to snapshot iteration in CopyOnWriteArrayList
    private static void useCopyOnWriteArrayList() {
        CopyOnWriteArrayList<String> listeners = new CopyOnWriteArrayList<>();
        listeners.add("Listener1");
        listeners.add("Listener2");

        Thread notifier = new Thread(() -> {
            for (String listener : listeners) {
                System.out.println("Notifying: " + listener);
                if (listener.equals("Listener1")) {
                    listeners.remove("Listener2"); // Safe
                }
            }
        });

        notifier.start();
        try {
            notifier.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void useArrayList2() {
        List<String> listeners = new ArrayList<>();
        listeners.add("Listener1");
        listeners.add("Listener2");
        listeners.add("Listener3");
        listeners.add("Listener4");

        Thread notifier = new Thread(() -> {
            for (String listener : listeners) {
                System.out.println("Notifying: " + listener);
                if (listener.equals("Listener1")) {
                    listeners.remove("Listener2"); // Should fail
                }
                try {
                    Thread.sleep(50); // Slow down to increase chance of failure
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        notifier.start();
        try {
            notifier.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

