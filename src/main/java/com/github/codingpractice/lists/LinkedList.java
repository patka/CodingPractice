package com.github.codingpractice.lists;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList<T> add(T item) {
        if (head == null) {
            head = new Node<T>(item);
            tail = head;
        }
        Node<T> newNode = new Node<T>(item);
        tail.setNext(newNode);
        tail = newNode;
        return this;
    }
}
