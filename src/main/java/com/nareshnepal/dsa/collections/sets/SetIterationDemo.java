package com.nareshnepal.dsa.collections.sets;

import java.util.*;
import java.util.Spliterator;

public class SetIterationDemo {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>(Arrays.asList("Alice", "Bob", "Carol", "Dave"));

        System.out.println("1. Enhanced for-loop:");
        enhancedForLoop(names);

        names = new HashSet<>(Arrays.asList("Alice", "Bob", "Carol", "Dave"));
        System.out.println("\n2. Iterator with removal (remove names starting with 'C'):");
        iteratorWithRemoval(names);

        names = new HashSet<>(Arrays.asList("Alice", "Bob", "Carol", "Dave"));
        System.out.println("\n3. Collection.forEach with lambda:");
        forEachLambda(names);

        names = new HashSet<>(Arrays.asList("Alice", "Bob", "Carol", "Dave"));
        System.out.println("\n4. Streams API (filter names longer than 3 chars):");
        streamApiIteration(names);

        names = new HashSet<>(Arrays.asList("Alice", "Bob", "Carol", "Dave"));
        System.out.println("\n5. Spliterator:");
        spliteratorIteration(names);
    }

    // 1. Enhanced for-loop
    public static void enhancedForLoop(Set<String> set) {
        for (String item : set) {
            System.out.println("  " + item);
        }
    }

    // 2. Iterator with removal
    public static void iteratorWithRemoval(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("  Visiting: " + item);
            if (item.startsWith("C")) {
                it.remove();
                System.out.println("    -> Removed: " + item);
            }
        }
        System.out.println("  After removal: " + set);
    }

    // 3. Collection.forEach with lambda
    public static void forEachLambda(Set<String> set) {
        set.forEach(item -> System.out.println("  " + item));
    }

    // 4. Streams API
    public static void streamApiIteration(Set<String> set) {
        set.stream()
                .filter(item -> item.length() > 3)
                .forEach(item -> System.out.println("  " + item));
    }

    // 5. Spliterator
    public static void spliteratorIteration(Set<String> set) {
        Spliterator<String> spliterator = set.spliterator();
        spliterator.forEachRemaining(item -> System.out.println("  " + item));
    }
}

