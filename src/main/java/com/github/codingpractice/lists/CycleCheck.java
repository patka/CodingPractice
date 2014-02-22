package com.github.codingpractice.lists;

/**
 * @author Patrick Kranz
 */
public class CycleCheck {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(15);
        Node<Integer> head = node;
        Node<Integer> cycleNode = null;
        for (int i = 0; i<10; i++) {
            Node<Integer> newNode = new Node<>(i);
            node.setNext(newNode);
            node = newNode;
            if (i == 5)
                cycleNode = newNode;
        }
        // create cycle
        node.setNext(cycleNode);

        Node<Integer> pointer1 = head;
        Node<Integer> pointer2 = head;
        int stepsize = 2;
        while (pointer1.getNext() != null) {
            for (int i = 0; i<stepsize; i++) {
                if (pointer2.getNext() != null) {
                    pointer2 = pointer2.getNext();
                    if (pointer2 == pointer1) {
                        System.out.println("Cycle detected");
                        System.out.println("Cycle size is " + i);
                        FindCycle(head, i);
                        return;
                    }
                } else {
                    System.out.println("No cycle detected");
                    return;
                }
            }
            stepsize *= 2;
            // we iterate over list
            pointer1 = pointer2;
        }
    }

    private static void FindCycle(Node<Integer> head, int cycleSize) {
        Node<Integer> pointer1 = head;
        Node<Integer> pointer2 = head;
        for (int i = 0; i<=cycleSize; i++) {
            pointer2 = pointer2.getNext();
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }
        System.out.println("Cycle detected on node " + pointer1.getItem());
    }
}
