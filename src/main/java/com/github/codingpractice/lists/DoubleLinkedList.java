package com.github.codingpractice.lists;

public class DoubleLinkedList<T extends Comparable> {
	private Node<T> head;
	private Node<T> tail;

	public void insert(T item) {
		if (item == null) return;
		
		if (isEmpty()) { 
			head = new Node<>(item);
			tail = head;
			return;
		}

		Node<T> newNode = new Node<>(item);
		tail.setNext(newNode);
		newNode.setPrevious(tail);
		tail = newNode;
	}

	public void delete(T item) {
		if (item == null) return;

		Node<T> toDelete = search(item);

		// element is not in list
		if (toDelete == null) return;

		Node<T> previous = toDelete.getPrevious();
		Node<T> next = toDelete.getNext();

		if (previous == null) {
			// we are dealing with head;
			head = next;
		} else {
			previous.setNext(next);
		}

		if (next == null) {
			// we are dealing with tail;
			tail = previous;
		} else {
			next.setPrevious(previous);
		}
	}

	public T getMinimum() {
		if (isEmpty()) return null;

		T minimum = head.getItem();
		Node<T> currentNode = head.getNext();
		while(currentNode != null) {
			if (currentNode.getItem().compareTo(minimum) < 0) {
				minimum = currentNode.getItem();
			}
			currentNode = currentNode.getNext();
		}
		return minimum;	
	}

	public boolean isEmpty() {
		return head == null;
	}

	public boolean contains(T item) {
		return search(item) != null;
	}

	public T get(int index) {
		Node<T> currentNode = head;
		int counter = 0;
		while(currentNode != null && counter < index) {
			currentNode = currentNode.getNext();
			counter++;
		}
		if (currentNode == null) {
			throw new ArrayIndexOutOfBoundsException("List only contains " + counter + " elements.");
		} else {
			return currentNode.getItem();
		}
	}

	private Node<T> search(T item) {
		if (isEmpty()) return null;

		return search(head, item);
	}

	private static<T> Node<T> search(Node<T> list, T toFind) {
		if (list == null) return null;

		if (list.getItem().equals(toFind)) return list;

		return search(list.getNext(), toFind);
	}

	@Override
	public String toString() {
		if (isEmpty()) return "";

		StringBuilder builder = new StringBuilder();
		Node<T> currentNode = head;
		while(currentNode != null) {
			builder.append(currentNode.getItem().toString());
			if (currentNode.getNext() != null) {
				builder.append(" ");
			}
			currentNode = currentNode.getNext();
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		list.insert(10);
		list.insert(8);
		list.insert(17);
		list.insert(12);
		list.insert(20);
		System.out.println(list.toString());
		list.delete(10);
		System.out.println(list.toString());
		list.delete(20);
		System.out.println(list.toString());
		list.delete(17);
		System.out.println(list.toString());
		list.insert(22);
		list.insert(1);
		list.insert(29);
		System.out.println(list.toString());
		System.out.println(list.get(2));
		System.out.println(list.getMinimum());
	}
}
