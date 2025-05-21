package com.nareshnepal.dsa.queues;

import java.util.*;
import java.util.Spliterator;

public class QueueIterationDemo {

    public static void main(String[] args) {
        Queue<String> queue;

        queue = sampleQueue();
        System.out.println("1. Enhanced for-loop:");
        enhancedForLoop(queue);

        queue = sampleQueue();
        System.out.println("\n2. Iterator:");
        iteratorLoop(queue);

        queue = sampleQueue();
        System.out.println("\n3. poll() until empty:");
        pollLoop(queue);

        queue = sampleQueue();
        System.out.println("\n4. forEach(lambda):");
        forEachLambda(queue);

        queue = sampleQueue();
        System.out.println("\n5. Stream API:");
        streamApiLoop(queue);

        queue = sampleQueue();
        System.out.println("\n6. Spliterator forEachRemaining:");
        spliteratorForEachRemaining(queue);

        queue = sampleQueue();
        System.out.println("\n7. Spliterator tryAdvance:");
        spliteratorTryAdvance(queue);

        queue = sampleQueue();
        System.out.println("\n8. toArray then loop:");
        toArrayLoop(queue);
    }

    private static Queue<String> sampleQueue() {
        Queue<String> q = new LinkedList<>();
        q.add("Alice");
        q.add("Bob");
        q.add("Carol");
        q.add("Dave");
        return q;
    }

    // 1. Enhanced for-loop
    public static void enhancedForLoop(Queue<String> queue) {
        for (String item : queue) {
            System.out.println("  " + item);
        }
    }

    // 2. Iterator
    public static void iteratorLoop(Queue<String> queue) {
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }
    }

    // 3. poll() until empty
    public static void pollLoop(Queue<String> queue) {
        String item;
        while ((item = queue.poll()) != null) {
            System.out.println("  " + item);
        }
    }

    // 4. forEach(lambda)
    public static void forEachLambda(Queue<String> queue) {
        queue.forEach(item -> System.out.println("  " + item));
    }

    // 5. Stream API
    public static void streamApiLoop(Queue<String> queue) {
        queue.stream()
                .forEach(item -> System.out.println("  " + item));
    }

    // 6. Spliterator forEachRemaining
    public static void spliteratorForEachRemaining(Queue<String> queue) {
        Spliterator<String> spl = queue.spliterator();
        spl.forEachRemaining(item -> System.out.println("  " + item));
    }

    // 7. Spliterator tryAdvance
    public static void spliteratorTryAdvance(Queue<String> queue) {
        Spliterator<String> spl = queue.spliterator();
        while (spl.tryAdvance(item -> System.out.println("  " + item))) {
            // one by one
        }
    }

    // 8. toArray then loop
    public static void toArrayLoop(Queue<String> queue) {
        Object[] arr = queue.toArray();
        for (Object obj : arr) {
            System.out.println("  " + obj);
        }
    }
}

