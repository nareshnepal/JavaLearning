package com.nareshnepal.dsa.concurrentcollections;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentVsNormalCollections {

    public static void main(String[] args) throws InterruptedException {
        demoArrayListVsCopyOnWriteArrayList();
        demoHashMapVsConcurrentHashMap();
        demoHashSetVsConcurrentSkipListSet();
        demoLinkedListVsConcurrentLinkedQueue();
        demoArrayDequeVsLinkedBlockingDeque();
        demoSynchronizedListVsCOWList();
        demoSynchronizedMapVsConcurrentMap();
        demoVectorVsCopyOnWriteArrayList();
    }

    private static void demoArrayListVsCopyOnWriteArrayList() {
        System.out.println("\n1. ArrayList vs CopyOnWriteArrayList");

        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C"));
        List<String> cowList = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        try {
            for (String s : arrayList) {
                System.out.println("ArrayList: " + s);
                arrayList.add("X");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ArrayList threw CME");
        }

        for (String s : cowList) {
            System.out.println("COWList: " + s);
            cowList.add("Y");
        }
    }

    private static void demoHashMapVsConcurrentHashMap() throws InterruptedException {
        System.out.println("\n2. HashMap vs ConcurrentHashMap");

        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();

        Runnable writer = () -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put("key" + i, "val" + i);
                concurrentMap.put("key" + i, "val" + i);
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(writer);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("HashMap size (may be wrong): " + hashMap.size());
        System.out.println("ConcurrentHashMap size: " + concurrentMap.size());
    }

    private static void demoHashSetVsConcurrentSkipListSet() {
        System.out.println("\n3. HashSet vs ConcurrentSkipListSet");

        Set<String> hashSet = new HashSet<>(List.of("A", "B", "C"));
        Set<String> concurrentSet = new ConcurrentSkipListSet<>(List.of("A", "B", "C"));

        try {
            for (String s : hashSet) {
                System.out.println("HashSet: " + s);
                hashSet.add("X");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("HashSet threw CME");
        }

        for (String s : concurrentSet) {
            System.out.println("ConcurrentSkipListSet: " + s);
            concurrentSet.add("Y");
        }
    }

    private static void demoLinkedListVsConcurrentLinkedQueue() {
        System.out.println("\n4. LinkedList vs ConcurrentLinkedQueue");

        Queue<String> linkedList = new LinkedList<>(List.of("A", "B", "C"));
        Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>(List.of("A", "B", "C"));

        try {
            for (String s : linkedList) {
                System.out.println("LinkedList: " + s);
                linkedList.remove(s);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("LinkedList threw CME");
        }

        for (String s : concurrentQueue) {
            System.out.println("ConcurrentLinkedQueue: " + s);
            concurrentQueue.remove(s);
        }
    }

    private static void demoArrayDequeVsLinkedBlockingDeque() {
        System.out.println("\n5. ArrayDeque vs LinkedBlockingDeque");

        Deque<Integer> arrayDeque = new ArrayDeque<>(List.of(1, 2, 3));
        Deque<Integer> blockingDeque = new LinkedBlockingDeque<>(List.of(1, 2, 3));

        // Demo: ArrayDeque throws ConcurrentModificationException
        try {
            for (Integer i : arrayDeque) {
                System.out.println("ArrayDeque: " + i);
                arrayDeque.add(99); // Modifying during iteration causes CME
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ArrayDeque threw CME");
        }

        // Demo: LinkedBlockingDeque allows concurrent modification - prevent infinite loop
        int count = 0;
        for (Integer i : blockingDeque) {
            System.out.println("BlockingDeque: " + i);
            if (count++ == 0) { // Only modify once to avoid infinite loop
                blockingDeque.add(100);
            }
        }
    }


//    private static void demoArrayDequeVsLinkedBlockingDeque() {
//        System.out.println("\n5. ArrayDeque vs LinkedBlockingDeque");
//
//        Deque<Integer> arrayDeque = new ArrayDeque<>(List.of(1, 2, 3));
//        Deque<Integer> blockingDeque = new LinkedBlockingDeque<>(List.of(1, 2, 3));
//
//        try {
//            for (Integer i : arrayDeque) {
//                System.out.println("ArrayDeque: " + i);
//                arrayDeque.add(99);
//            }
//        } catch (ConcurrentModificationException e) {
//            System.out.println("ArrayDeque threw CME");
//        }
//
//        for (Integer i : blockingDeque) {
//            System.out.println("BlockingDeque: " + i);
//            blockingDeque.add(100);
//        }
//    }

    private static void demoSynchronizedListVsCOWList() {
        System.out.println("\n6. SynchronizedList vs CopyOnWriteArrayList");

        List<String> syncList = Collections.synchronizedList(new ArrayList<>(List.of("A", "B", "C")));
        List<String> cowList = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        synchronized (syncList) {
            for (String s : syncList) {
                System.out.println("SynchronizedList: " + s);
                syncList.add("X"); // safe because we synchronized
            }
        }

        for (String s : cowList) {
            System.out.println("COWList: " + s);
            cowList.add("Y");
        }
    }

    private static void demoSynchronizedMapVsConcurrentMap() {
        System.out.println("\n7. SynchronizedMap vs ConcurrentHashMap");

        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();

        syncMap.put("A", "1");
        concurrentMap.put("A", "1");

        synchronized (syncMap) {
            for (String k : syncMap.keySet()) {
                System.out.println("SynchronizedMap: " + k);
                syncMap.put("B", "2");
            }
        }

        for (String k : concurrentMap.keySet()) {
            System.out.println("ConcurrentMap: " + k);
            concurrentMap.put("B", "2");
        }
    }

    private static void demoVectorVsCopyOnWriteArrayList() {
        System.out.println("\n8. Vector vs CopyOnWriteArrayList");

        List<String> vector = new Vector<>(List.of("A", "B", "C"));
        List<String> cowList = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        for (String s : vector) {
            System.out.println("Vector: " + s);
            vector.add("X"); // Vector handles internally synchronized
        }

        for (String s : cowList) {
            System.out.println("COWList: " + s);
            cowList.add("Y");
        }
    }
}

