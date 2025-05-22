package com.nareshnepal.dsa.collections.sets;

import java.util.*;

public class NavigableSetExamples {

    public static void main(String[] args) {
        NavigableSetExamples examples = new NavigableSetExamples();

        examples.demoCeiling();
        examples.demoFloor();
        examples.demoHigher();
        examples.demoLower();
        examples.demoPollFirst();
        examples.demoPollLast();
        examples.demoDescendingSet();
        examples.demoHeadSet();
        examples.demoTailSet();
        examples.demoSubSet();
    }

    // 1. ceiling(E e) — least element >= e
    public void demoCeiling() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("ceiling(15): " + set.ceiling(15)); // 20
    }

    // 2. floor(E e) — greatest element <= e
    public void demoFloor() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("floor(25): " + set.floor(25)); // 20
    }

    // 3. higher(E e) — least element > e
    public void demoHigher() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("higher(20): " + set.higher(20)); // 30
    }

    // 4. lower(E e) — greatest element < e
    public void demoLower() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("lower(20): " + set.lower(20)); // 10
    }

    // 5. pollFirst() — retrieves and removes the lowest
    public void demoPollFirst() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("pollFirst: " + set.pollFirst()); // 10
        System.out.println("after pollFirst: " + set);
    }

    // 6. pollLast() — retrieves and removes the highest
    public void demoPollLast() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("pollLast: " + set.pollLast()); // 30
        System.out.println("after pollLast: " + set);
    }

    // 7. descendingSet() — returns elements in reverse order
    public void demoDescendingSet() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        NavigableSet<Integer> descending = set.descendingSet();
        System.out.println("descendingSet: " + descending); // [30, 20, 10]
    }

    // 8. headSet(E toElement, boolean inclusive)
    public void demoHeadSet() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40));
        System.out.println("headSet(30, true): " + set.headSet(30, true)); // [10, 20, 30]
    }

    // 9. tailSet(E fromElement, boolean inclusive)
    public void demoTailSet() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40));
        System.out.println("tailSet(20, false): " + set.tailSet(20, false)); // [30, 40]
    }

    // 10. subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
    public void demoSubSet() {
        NavigableSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40, 50));
        NavigableSet<Integer> sub = set.subSet(20, true, 40, false);
        System.out.println("subSet(20, true, 40, false): " + sub); // [20, 30]
    }
}

