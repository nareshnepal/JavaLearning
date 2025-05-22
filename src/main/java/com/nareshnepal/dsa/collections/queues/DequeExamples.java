package com.nareshnepal.dsa.collections.queues;

import java.util.*;

public class DequeExamples {

    public static void main(String[] args) {
        DequeExamples examples = new DequeExamples();

        examples.demoAddFirstAndLast();
        examples.demoOfferFirstAndLast();
        examples.demoRemoveFirstAndLast();
        examples.demoPollFirstAndLast();
        examples.demoPeekFirstAndLast();
        examples.demoGetFirstAndLast();
        examples.demoPushPop();
    }

    public void demoAddFirstAndLast() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("A");
        deque.addLast("B");
        System.out.println("addFirst/Last: " + deque); // [A, B]
    }

    public void demoOfferFirstAndLast() {
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("X");
        deque.offerLast("Y");
        System.out.println("offerFirst/Last: " + deque); // [X, Y]
    }

    public void demoRemoveFirstAndLast() {
        Deque<String> deque = new LinkedList<>(List.of("1", "2", "3"));
        String first = deque.removeFirst();
        String last = deque.removeLast();
        System.out.println("removeFirst(): " + first + ", removeLast(): " + last); // 1, 3
        System.out.println("After remove: " + deque); // [2]
    }

    public void demoPollFirstAndLast() {
        Deque<String> deque = new LinkedList<>(List.of("A", "B", "C"));
        String first = deque.pollFirst();
        String last = deque.pollLast();
        System.out.println("pollFirst(): " + first + ", pollLast(): " + last); // A, C
        System.out.println("After poll: " + deque); // [B]
    }

    public void demoPeekFirstAndLast() {
        Deque<String> deque = new LinkedList<>(List.of("X", "Y", "Z"));
        System.out.println("peekFirst(): " + deque.peekFirst()); // X
        System.out.println("peekLast(): " + deque.peekLast()); // Z
    }

    public void demoGetFirstAndLast() {
        Deque<String> deque = new LinkedList<>(List.of("10", "20", "30"));
        System.out.println("getFirst(): " + deque.getFirst()); // 10
        System.out.println("getLast(): " + deque.getLast()); // 30
    }

    public void demoPushPop() {
        Deque<String> stack = new LinkedList<>();
        stack.push("One");  // addFirst
        stack.push("Two");  // addFirst
        System.out.println("After push: " + stack); // [Two, One]
        System.out.println("pop(): " + stack.pop()); // Two
        System.out.println("After pop: " + stack); // [One]
    }
}

