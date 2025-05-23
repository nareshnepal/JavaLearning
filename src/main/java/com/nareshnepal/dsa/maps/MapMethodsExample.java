package com.nareshnepal.dsa.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class MapMethodsExample {

    public static void main(String[] args) {
        MapMethodsExample example = new MapMethodsExample();

        example.demoPutGet();
        example.demoRemove();
        example.demoContainsKeyValue();
        example.demoKeySetValuesEntrySet();
        example.demoPutIfAbsent();
        example.demoComputeMethods();
        example.demoMerge();
        example.demoReplace();
        example.demoClearSize();
    }

    // put and get
    public void demoPutGet() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        System.out.println("Get apple: " + map.get("apple"));  // 10
    }

    // remove by key
    public void demoRemove() {
        Map<String, Integer> map = new HashMap<>();
        map.put("cat", 5);
        map.remove("cat");
        System.out.println("Contains 'cat' after remove? " + map.containsKey("cat")); // false
    }

    // containsKey and containsValue
    public void demoContainsKeyValue() {
        Map<String, String> map = new HashMap<>();
        map.put("x", "alpha");
        System.out.println("Contains key 'x'? " + map.containsKey("x"));           // true
        System.out.println("Contains value 'alpha'? " + map.containsValue("alpha")); // true
    }

    // keySet, values, entrySet
    public void demoKeySetValuesEntrySet() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Set<Integer> keys = map.keySet();
        Collection<String> values = map.values();
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
        System.out.println("Entries: " + entries);
    }

    // putIfAbsent
    public void demoPutIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key", 100);
        map.putIfAbsent("key", 200);  // won't override existing value
        System.out.println("Value for 'key': " + map.get("key"));  // 100
    }

    // compute, computeIfAbsent, computeIfPresent
    public void demoComputeMethods() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);

        map.compute("a", (k, v) -> v == null ? 42 : v + 10);
        System.out.println("After compute on 'a': " + map.get("a"));  // 11

        map.computeIfAbsent("b", k -> 20);
        System.out.println("After computeIfAbsent on 'b': " + map.get("b"));  // 20

        map.computeIfPresent("a", (k, v) -> v * 2);
        System.out.println("After computeIfPresent on 'a': " + map.get("a"));  // 22
    }

    // merge
    public void demoMerge() {
        Map<String, Integer> map = new HashMap<>();
        map.put("x", 3);
        map.merge("x", 7, Integer::sum);
        map.merge("y", 5, Integer::sum);
        System.out.println("After merge: " + map); // {x=10, y=5}
    }

    // replace
    public void demoReplace() {
        Map<String, Integer> map = new HashMap<>();
        map.put("k", 100);
        map.replace("k", 200);
        System.out.println("After replace: " + map.get("k")); // 200

        boolean replaced = map.replace("k", 200, 300);
        System.out.println("Replaced with condition: " + replaced); // true
        System.out.println("New value for 'k': " + map.get("k")); // 300
    }

    // clear and size
    public void demoClearSize() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        System.out.println("Size before clear: " + map.size());
        map.clear();
        System.out.println("Size after clear: " + map.size());
    }
}
