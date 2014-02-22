package com.github.codingpractice.lists;

public class Node<T> {
	private T item;
	private Node<T> next;
	private Node<T> previous;

	public Node(T item) {
		if (item == null) {
			throw new IllegalArgumentException("Item must not be null");
		}
		this.item = item;
	}

	public T getItem() {
		return this.item;
	}

	public Node<T> setNext(Node<T> next) {
		this.next = next;
		return getNext();
	}

	public Node<T> getNext() {
		return this.next;
	}

	public Node<T> setPrevious(Node<T> previous) {
		this.previous = previous;
		return getPrevious();
	}

	public Node<T> getPrevious() {
		return this.previous;
	}
}
