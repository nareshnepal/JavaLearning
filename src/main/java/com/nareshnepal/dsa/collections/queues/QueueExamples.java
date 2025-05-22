package com.nareshnepal.dsa.collections.queues;

import java.util.*;

public class QueueExamples {

    public static void main(String[] args) {
        QueueExamples examples = new QueueExamples();

        examples.demoOffer();
        examples.demoPoll();
        examples.demoPeek();
        examples.demoElement();
        examples.demoRemove();
    }

    // 1. offer(E e) — adds element, returns false if capacity restriction prevents insertion
    public void demoOffer() {
        Queue<String> queue = new LinkedList<>();
        boolean added = queue.offer("A");
        System.out.println("offer('A'): " + added); // true
        System.out.println("Queue after offer: " + queue); // [A]
    }

    // 2. poll() — retrieves and removes head, returns null if empty
    public void demoPoll() {
        Queue<String> queue = new LinkedList<>(List.of("A", "B", "C"));
        String removed = queue.poll();
        System.out.println("poll(): " + removed); // A
        System.out.println("Queue after poll: " + queue); // [B, C]
    }

    // 3. peek() — retrieves (but doesn't remove) head, null if empty
    public void demoPeek() {
        Queue<String> queue = new LinkedList<>(List.of("A", "B"));
        String head = queue.peek();
        System.out.println("peek(): " + head); // A
        System.out.println("Queue after peek: " + queue); // [A, B]
    }

    // 4. element() — like peek() but throws exception if empty
    public void demoElement() {
        Queue<String> queue = new LinkedList<>(List.of("X", "Y"));
        String head = queue.element();
        System.out.println("element(): " + head); // X
        System.out.println("Queue after element(): " + queue); // [X, Y]
    }

    // 5. remove() — like poll() but throws exception if empty
    public void demoRemove() {
        Queue<String> queue = new LinkedList<>(List.of("A", "B", "C"));
        String removed = queue.remove();
        System.out.println("remove(): " + removed); // A
        System.out.println("Queue after remove: " + queue); // [B, C]
    }
}

