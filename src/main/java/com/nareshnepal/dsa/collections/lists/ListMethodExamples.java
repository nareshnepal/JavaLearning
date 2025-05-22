package com.nareshnepal.dsa.collections.lists;

import java.util.*;

public class ListMethodExamples {

    public static void main(String[] args) {
        ListMethodExamples example = new ListMethodExamples();

        example.addAtIndex();
        example.getElement();
        example.setElement();
        example.removeByIndex();
        example.indexOfElement();
        example.lastIndexOfElement();
        example.useListIterator();
        example.useListIteratorFromIndex();
        example.subListExample();
    }

    // 1. add(int index, E element)
    public void addAtIndex() {
        List<String> list = new ArrayList<>(List.of("A", "B", "D"));
        list.add(2, "C");  // Insert "C" at index 2
        System.out.println("add(index, element): " + list);
    }

    // 2. get(int index)
    public void getElement() {
        List<String> list = List.of("A", "B", "C");
        String element = list.get(1);  // Get element at index 1
        System.out.println("get(index): " + element);
    }

    // 3. set(int index, E element)
    public void setElement() {
        List<String> list = new ArrayList<>(List.of("A", "X", "C"));
        list.set(1, "B");  // Replace element at index 1
        System.out.println("set(index, element): " + list);
    }

    // 4. remove(int index)
    public void removeByIndex() {
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));
        list.remove(1);  // Remove element at index 1
        System.out.println("remove(index): " + list);
    }

    // 5. indexOf(Object o)
    public void indexOfElement() {
        List<String> list = List.of("A", "B", "C", "B");
        int index = list.indexOf("B");  // First occurrence
        System.out.println("indexOf(\"B\"): " + index);
    }

    // 6. lastIndexOf(Object o)
    public void lastIndexOfElement() {
        List<String> list = List.of("A", "B", "C", "B");
        int index = list.lastIndexOf("B");  // Last occurrence
        System.out.println("lastIndexOf(\"B\"): " + index);
    }

    // 7. listIterator()
    public void useListIterator() {
        List<String> list = List.of("A", "B", "C");
        ListIterator<String> it = list.listIterator();
        System.out.print("listIterator(): ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    // 8. listIterator(int index)
    public void useListIteratorFromIndex() {
        List<String> list = List.of("A", "B", "C", "D");
        ListIterator<String> it = list.listIterator(2);
        System.out.print("listIterator(startIndex): ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    // 9. subList(int fromIndex, int toIndex)
    public void subListExample() {
        List<String> list = List.of("A", "B", "C", "D", "E");
        List<String> subList = list.subList(1, 4);  // [B, C, D]
        System.out.println("subList(1, 4): " + subList);
    }
}
