package com.nareshnepal.dsa.collections.sets;

import java.util.*;

public class SortedSetExamples {

    public static void main(String[] args) {
        SortedSetExamples examples = new SortedSetExamples();

        examples.demoFirst();
        examples.demoLast();
        examples.demoHeadSet();
        examples.demoTailSet();
        examples.demoSubSet();
        examples.demoComparator();
    }

    // 1. first() — returns the lowest element
    public void demoFirst() {
        SortedSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("first(): " + set.first()); // 10
    }

    // 2. last() — returns the highest element
    public void demoLast() {
        SortedSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30));
        System.out.println("last(): " + set.last()); // 30
    }

    // 3. headSet(E toElement) — all elements < toElement
    public void demoHeadSet() {
        SortedSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40));
        SortedSet<Integer> head = set.headSet(30);
        System.out.println("headSet(30): " + head); // [10, 20]
    }

    // 4. tailSet(E fromElement) — all elements ≥ fromElement
    public void demoTailSet() {
        SortedSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40));
        SortedSet<Integer> tail = set.tailSet(20);
        System.out.println("tailSet(20): " + tail); // [20, 30, 40]
    }

    // 5. subSet(E fromElement, E toElement) — elements in range [fromElement, toElement)
    public void demoSubSet() {
        SortedSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40, 50));
        SortedSet<Integer> sub = set.subSet(20, 40);
        System.out.println("subSet(20, 40): " + sub); // [20, 30]
    }

    // 6. comparator() — returns the comparator used or null if natural ordering
    public void demoComparator() {
        SortedSet<String> set = new TreeSet<>(); // natural ordering
        System.out.println("comparator(): " + set.comparator()); // null

        SortedSet<String> customSet = new TreeSet<>(Comparator.reverseOrder());
        System.out.println("comparator() (custom): " + customSet.comparator()); // java.util.Comparator$$Lambda...
    }
}

