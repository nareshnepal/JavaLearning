package com.nareshnepal.dsa.concurrentcollections;

import java.util.ArrayList;
import java.util.List;

public class CMEExampleSameThread {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));

        try {
            for (String item : list) {
                System.out.println("Reading: " + item);
                list.remove("C"); // Always removing the same item to force structural change
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }

        // Correct way
        list = new ArrayList<>(List.of("A", "B", "C"));
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("B")) {
                iterator.remove();  // Safe removal during iteration
            }
        }
        System.out.println("List after safe removal: " + list);
    }
}

