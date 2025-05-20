package com.nareshnepal.dsa.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayTraversalExamples {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("1. For loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("\n2. Enhanced for loop:");
        for (int num : arr) {
            System.out.println(num);
        }

        System.out.println("\n3. While loop:");
        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }

        System.out.println("\n4. Do-while loop:");
        i = 0;
        do {
            System.out.println(arr[i]);
            i++;
        } while (i < arr.length);

        System.out.println("\n5. Java Streams:");
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("\n6. Recursion:");
        printRecursively(arr, 0);

        System.out.println("\n7. Iterator (via List):");
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n8. Reverse traversal (for loop):");
        for (int j = arr.length - 1; j >= 0; j--) {
            System.out.println(arr[j]);
        }
    }

    private static void printRecursively(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.println(arr[index]);
        printRecursively(arr, index + 1);
    }
}
