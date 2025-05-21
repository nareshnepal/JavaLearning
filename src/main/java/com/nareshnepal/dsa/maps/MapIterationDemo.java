package com.nareshnepal.dsa.maps;

import java.util.*;
import java.util.Spliterator;

public class MapIterationDemo {

    public static void main(String[] args) {
        Map<String, Integer> map;

        map = sampleMap();
        System.out.println("1. entrySet for-each:");
        entrySetForEach(map);

        map = sampleMap();
        System.out.println("\n2. entrySet iterator:");
        entrySetIterator(map);

        map = sampleMap();
        System.out.println("\n3. keySet for-each with get():");
        keySetForEach(map);

        map = sampleMap();
        System.out.println("\n4. keySet iterator with get():");
        keySetIterator(map);

        map = sampleMap();
        System.out.println("\n5. values for-each (values only):");
        valuesForEach(map);

        map = sampleMap();
        System.out.println("\n6. Map.forEach BiConsumer:");
        mapForEachBiConsumer(map);

        map = sampleMap();
        System.out.println("\n7. entrySet stream:");
        entryStream(map);

        map = sampleMap();
        System.out.println("\n8. parallelStream on entrySet:");
        parallelStream(map);

        map = sampleMap();
        System.out.println("\n9. Spliterator forEachRemaining on entrySet:");
        spliteratorForEachRemaining(map);

        map = sampleMap();
        System.out.println("\n10. Spliterator tryAdvance on entrySet:");
        spliteratorTryAdvance(map);
    }

    private static Map<String, Integer> sampleMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Carol", 27);
        map.put("Dave", 32);
        return map;
    }

    // 1. entrySet for-each
    public static void entrySetForEach(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 2. entrySet iterator
    public static void entrySetIterator(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 3. keySet for-each with get()
    public static void keySetForEach(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println("  " + key + " -> " + map.get(key));
        }
    }

    // 4. keySet iterator with get()
    public static void keySetIterator(Map<String, Integer> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println("  " + key + " -> " + map.get(key));
        }
    }

    // 5. values for-each (values only)
    public static void valuesForEach(Map<String, Integer> map) {
        for (Integer value : map.values()) {
            System.out.println("  value: " + value);
        }
    }

    // 6. Map.forEach BiConsumer
    public static void mapForEachBiConsumer(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println("  " + key + " -> " + value));
    }

    // 7. entrySet stream
    public static void entryStream(Map<String, Integer> map) {
        map.entrySet()
                .stream()
                .forEach(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));
    }

    // 8. parallelStream on entrySet
    public static void parallelStream(Map<String, Integer> map) {
        map.entrySet()
                .parallelStream()
                .forEach(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));
    }

    // 9. Spliterator forEachRemaining on entrySet
    public static void spliteratorForEachRemaining(Map<String, Integer> map) {
        Spliterator<Map.Entry<String, Integer>> spl = map.entrySet().spliterator();
        spl.forEachRemaining(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));
    }

    // 10. Spliterator tryAdvance on entrySet
    public static void spliteratorTryAdvance(Map<String, Integer> map) {
        Spliterator<Map.Entry<String, Integer>> spl = map.entrySet().spliterator();
        while (spl.tryAdvance(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()))) {
            // element-by-element
        }
    }
}

