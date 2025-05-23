package com.nareshnepal.dsa.concurrentcollections;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollectionDemos {

    public static void main(String[] args) throws InterruptedException {
        demoArrayListVsCopyOnWriteArrayList();
        demoHashMapVsConcurrentHashMap();
        demoLinkedListVsConcurrentLinkedQueue();
        demoArrayDequeVsLinkedBlockingDeque();
        demoHashSetVsConcurrentSet();
    }

    // 1. ArrayList vs CopyOnWriteArrayList
    private static void demoArrayListVsCopyOnWriteArrayList() throws InterruptedException {
        System.out.println("\n=== 1. ArrayList vs CopyOnWriteArrayList ===");

        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C"));
        List<String> cowList = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        Thread t1 = new Thread(() -> {
            try {
                for (String item : arrayList) {
                    System.out.println("ArrayList iterating: " + item);
                    Thread.sleep(10);
                    arrayList.add("X");
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("ArrayList: ConcurrentModificationException caught!");
            } catch (InterruptedException ignored) {}
        });

        Thread t2 = new Thread(() -> {
            for (String item : cowList) {
                System.out.println("COWList iterating: " + item);
                cowList.add("Y");
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    // 2. HashMap vs ConcurrentHashMap
    private static void demoHashMapVsConcurrentHashMap() throws InterruptedException {
        System.out.println("\n=== 2. HashMap vs ConcurrentHashMap ===");

        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            service.submit(() -> {
                hashMap.put("key" + finalI, "val" + finalI);
                concurrentHashMap.put("key" + finalI, "val" + finalI);
            });
        }

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("HashMap size (may be inconsistent or throw): " + hashMap.size());
        System.out.println("ConcurrentHashMap size: " + concurrentHashMap.size());
    }

    // 3. LinkedList vs ConcurrentLinkedQueue
    private static void demoLinkedListVsConcurrentLinkedQueue() throws InterruptedException {
        System.out.println("\n=== 3. LinkedList vs ConcurrentLinkedQueue ===");

        LinkedList<String> linkedList = new LinkedList<>(List.of("X", "Y", "Z"));
        Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>(List.of("X", "Y", "Z"));

        Thread t1 = new Thread(() -> {
            try {
                for (String s : linkedList) {
                    System.out.println("LinkedList reading: " + s);
                    Thread.sleep(10);
                    linkedList.remove(s); // triggers CME
                }
            } catch (Exception e) {
                System.out.println("LinkedList: Exception - " + e);
            }
        });

        Thread t2 = new Thread(() -> {
            for (String s : concurrentQueue) {
                System.out.println("ConcurrentQueue reading: " + s);
                concurrentQueue.remove(s);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    // 4. ArrayDeque vs LinkedBlockingDeque
    private static void demoArrayDequeVsLinkedBlockingDeque() throws InterruptedException {
        System.out.println("\n=== 4. ArrayDeque vs LinkedBlockingDeque ===");

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(List.of(1, 2, 3));
        LinkedBlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(List.of(1, 2, 3));

        Thread t1 = new Thread(() -> {
            try {
                for (Integer val : arrayDeque) {
                    System.out.println("ArrayDeque iterating: " + val);
                    Thread.sleep(20); // Allow t2 to modify the deque mid-iteration
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("ArrayDeque: ConcurrentModificationException caught!");
            } catch (InterruptedException ignored) {}
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(30); // Wait to ensure t1 starts iterating
                arrayDeque.add(99); // Structural modification during iteration
                System.out.println("ArrayDeque modified by t2");
            } catch (InterruptedException ignored) {}
        });

        Thread t3 = new Thread(() -> {
            try {
                while (!blockingDeque.isEmpty()) {
                    System.out.println("BlockingDeque take: " + blockingDeque.take());
                }
            } catch (InterruptedException ignored) {}
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    // 5. HashSet vs ConcurrentSkipListSet

    private static void demoHashSetVsConcurrentSet() throws InterruptedException {
        System.out.println("\n=== 5. HashSet vs ConcurrentSkipListSet ===");

        Set<String> hashSet = new HashSet<>(List.of("A", "B", "C"));
        Set<String> concurrentSet = new ConcurrentSkipListSet<>(Set.of("A", "B", "C"));

        Thread hashSetThread = new Thread(() -> {
            try {
                for (String item : hashSet) {
                    System.out.println("HashSet iterating: " + item);
                    Thread.sleep(50);
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("HashSet: ConcurrentModificationException caught!");
            } catch (InterruptedException ignored) {}
        });

        Thread hashSetModifier = new Thread(() -> {
            try {
                Thread.sleep(75); // Ensure modification happens during iteration
                hashSet.add("D");
                System.out.println("HashSet modified by another thread");
            } catch (InterruptedException ignored) {}
        });

        Thread concurrentSetThread = new Thread(() -> {
            try {
                for (String item : concurrentSet) {
                    System.out.println("ConcurrentSet iterating: " + item);
                    Thread.sleep(50);
                }
            } catch (InterruptedException ignored) {}
        });

        Thread concurrentSetModifier = new Thread(() -> {
            try {
                Thread.sleep(75); // Modify during iteration
                concurrentSet.add("D");
                System.out.println("ConcurrentSet modified by another thread");
            } catch (InterruptedException ignored) {}
        });

        hashSetThread.start();
        hashSetModifier.start();
        concurrentSetThread.start();
        concurrentSetModifier.start();

        hashSetThread.join();
        hashSetModifier.join();
        concurrentSetThread.join();
        concurrentSetModifier.join();
    }





}
