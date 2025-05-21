package com.nareshnepal.dsa.lists;

import java.util.*;

import java.util.*;
import java.util.stream.*;

public class ListTraversalDemo {

    public static void main(String[] args) {
        List<String> items = List.of("Apple", "Banana", "Cherry", "Date");

        ListTraversalDemo demo = new ListTraversalDemo();
        demo.traverseWithEnhancedFor(items);
        demo.traverseWithIndex(items);
        demo.traverseWithIterator(items);
        demo.traverseWithListIteratorForward(items);
        demo.traverseWithListIteratorBackward(items);
        demo.traverseWithStream(items);
        demo.traverseWithForEachLambda(items);
        demo.traverseWithWhileIndex(items);
    }

    // 1. Enhanced for-loop
    public void traverseWithEnhancedFor(List<String> list) {
        System.out.println("\n1. Enhanced for-loop:");
        for (String item : list) {
            System.out.println(item);
        }
    }

    // 2. Index-based for loop
    public void traverseWithIndex(List<String> list) {
        System.out.println("\n2. Index-based for-loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }
    }

    // 3. Using Iterator
    public void traverseWithIterator(List<String> list) {
        System.out.println("\n3. Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // 4. Using ListIterator (forward)
    public void traverseWithListIteratorForward(List<String> list) {
        System.out.println("\n4. ListIterator (forward):");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

    // 5. Using ListIterator (backward)
    public void traverseWithListIteratorBackward(List<String> list) {
        System.out.println("\n5. ListIterator (backward):");
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    // 6. Using Stream
    public void traverseWithStream(List<String> list) {
        System.out.println("\n6. Stream:");
        list.stream().forEach(System.out::println);
    }

    // 7. Using forEach with Lambda
    public void traverseWithForEachLambda(List<String> list) {
        System.out.println("\n7. forEach with Lambda:");
        list.forEach(item -> System.out.println(item));
    }

    // 8. Using while loop with index
    public void traverseWithWhileIndex(List<String> list) {
        System.out.println("\n8. While loop with index:");
        int i = 0;
        while (i < list.size()) {
            System.out.println("Index " + i + ": " + list.get(i));
            i++;
        }
    }
}
