package com.nareshnepal.dsa.collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CollectionMethodExamples {

    public static void main(String[] args) {
        CollectionMethodExamples example = new CollectionMethodExamples();

        example.demoAdd();
        example.demoAddAll();
        example.demoClear();
        example.demoContains();
        example.demoContainsAll();
        example.demoIsEmpty();
        example.demoIterator();
        example.demoRemoveObject();
        example.demoRemoveAll();
        example.demoRetainAll();
        example.demoSize();
        example.demoToArray();
        example.demoToArrayTyped();
        example.demoRemoveIf();
        example.demoSpliterator();
        example.demoStream();
        example.demoParallelStream();
    }

    // 1. add(E e)
    public void demoAdd() {
        Collection<String> coll = new ArrayList<>();
        coll.add("Apple");
        System.out.println("add: " + coll);
    }

    // 2. addAll(Collection<? extends E> c)
    public void demoAddAll() {
        Collection<String> coll1 = new ArrayList<>(List.of("Apple", "Banana"));
        Collection<String> coll2 = new ArrayList<>(List.of("Cherry", "Date"));
        coll1.addAll(coll2);
        System.out.println("addAll: " + coll1);
    }

    // 3. clear()
    public void demoClear() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        coll.clear();
        System.out.println("clear: " + coll);
    }

    // 4. contains(Object o)
    public void demoContains() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        System.out.println("contains(\"B\"): " + coll.contains("B"));
    }

    // 5. containsAll(Collection<?> c)
    public void demoContainsAll() {
        Collection<String> coll1 = new ArrayList<>(List.of("A", "B", "C"));
        Collection<String> coll2 = new ArrayList<>(List.of("B", "C"));
        System.out.println("containsAll: " + coll1.containsAll(coll2));
    }

    // 6. isEmpty()
    public void demoIsEmpty() {
        Collection<String> coll = new ArrayList<>();
        System.out.println("isEmpty: " + coll.isEmpty());
    }

    // 7. iterator()
    public void demoIterator() {
        Collection<String> coll = new ArrayList<>(List.of("X", "Y", "Z"));
        Iterator<String> it = coll.iterator();
        System.out.print("iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    // 8. remove(Object o)
    public void demoRemoveObject() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        boolean removed = coll.remove("B");
        System.out.println("remove(\"B\"): " + removed + ", after removal: " + coll);
    }

    // 9. removeAll(Collection<?> c)
    public void demoRemoveAll() {
        Collection<String> coll1 = new ArrayList<>(List.of("A", "B", "C", "D"));
        Collection<String> coll2 = new ArrayList<>(List.of("B", "D"));
        coll1.removeAll(coll2);
        System.out.println("removeAll: " + coll1);
    }

    // 10. retainAll(Collection<?> c)
    public void demoRetainAll() {
        Collection<String> coll1 = new ArrayList<>(List.of("A", "B", "C", "D"));
        Collection<String> coll2 = new ArrayList<>(List.of("B", "D", "E"));
        coll1.retainAll(coll2);
        System.out.println("retainAll: " + coll1);
    }

    // 11. size()
    public void demoSize() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        System.out.println("size: " + coll.size());
    }

    // 12. toArray()
    public void demoToArray() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        Object[] arr = coll.toArray();
        System.out.println("toArray: " + Arrays.toString(arr));
    }

    // 13. <T> T[] toArray(T[] a)
    public void demoToArrayTyped() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        String[] arr = coll.toArray(new String[0]);
        System.out.println("toArray(T[]): " + Arrays.toString(arr));
    }

    // 14. removeIf(Predicate<? super E> filter)
    public void demoRemoveIf() {
        Collection<String> coll = new ArrayList<>(List.of("Apple", "Banana", "Cherry", "Date"));
        coll.removeIf(s -> s.startsWith("B"));
        System.out.println("removeIf starts with B: " + coll);
    }

    // 15. spliterator()
    public void demoSpliterator() {
        Collection<String> coll = new ArrayList<>(List.of("X", "Y", "Z"));
        Spliterator<String> spliterator = coll.spliterator();
        System.out.print("spliterator tryAdvance: ");
        spliterator.tryAdvance(System.out::println);
    }

    // 16. stream()
    public void demoStream() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        System.out.print("stream forEach: ");
        coll.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    // 17. parallelStream()
    public void demoParallelStream() {
        Collection<String> coll = new ArrayList<>(List.of("A", "B", "C"));
        System.out.print("parallelStream forEach: ");
        coll.parallelStream().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}

