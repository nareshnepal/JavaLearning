package com.nareshnepal.dsa.collections.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ArrayDequeExamples {

    public static void main(String[] args) {
        ArrayDequeExamples examples = new ArrayDequeExamples();

        examples.demoAddFirstAndLast();
        examples.demoOfferFirstAndLast();
        examples.demoRemoveFirstAndLast();
        examples.demoPollFirstAndLast();
        examples.demoPeekFirstAndLast();
        examples.demoGetFirstAndLast();
        examples.demoPushPop();
    }

    public void demoAddFirstAndLast() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addLast("B");
        System.out.println("addFirst/Last: " + deque);
    }

    public void demoOfferFirstAndLast() {
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("X");
        deque.offerLast("Y");
        System.out.println("offerFirst/Last: " + deque);
    }

    public void demoRemoveFirstAndLast() {
        Deque<String> deque = new ArrayDeque<>(List.of("1", "2", "3"));
        String first = deque.removeFirst();
        String last = deque.removeLast();
        System.out.println("removeFirst(): " + first + ", removeLast(): " + last);
        System.out.println("After remove: " + deque);
    }

    public void demoPollFirstAndLast() {
        Deque<String> deque = new ArrayDeque<>(List.of("A", "B", "C"));
        String first = deque.pollFirst();
        String last = deque.pollLast();
        System.out.println("pollFirst(): " + first + ", pollLast(): " + last);
        System.out.println("After poll: " + deque);
    }

    public void demoPeekFirstAndLast() {
        Deque<String> deque = new ArrayDeque<>(List.of("X", "Y", "Z"));
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast(): " + deque.peekLast());
    }

    public void demoGetFirstAndLast() {
        Deque<String> deque = new ArrayDeque<>(List.of("10", "20", "30"));
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());
    }

    public void demoPushPop() {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("One");  // addFirst
        stack.push("Two");  // addFirst
        System.out.println("After push: " + stack);
        System.out.println("pop(): " + stack.pop());
        System.out.println("After pop: " + stack);
    }
}

