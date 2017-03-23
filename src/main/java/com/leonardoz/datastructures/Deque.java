package com.leonardoz.datastructures;

/*
 * Double-ended queue
 * Queue to insert/consume from the start or the end.
 */
public class Deque<E> {

	static class Node<E> {
		E value = null;
		Node<E> next = null;

		Node(E value, Node<E> next) {
			super();
			this.value = value;
			this.next = next;
		}
	}

	private Node<E> first, last;
	private int size;

	public void pushToEnd(E value) {
		if (size == 0) {
			first = new Node<>(value, null);
			last = first;
		} else {
			Node<E> node = new Node<>(value, null);
			Node<E> aux = last;
			last = node;
			aux.next = last;
		}
		size++;
	}

	public void pushToBeginning(E value) {
		if (size == 0) {
			first = new Node<>(value, null);
			last = first;
			first.next = last;
		} else {
			Node<E> aux = first;
			Node<E> node = new Node<>(value, aux);
			first = node;
		}
		size++;
	}

	public E popFirst() throws IllegalStateException {
		if (size == 0) {
			throw new IllegalStateException("Deque is empty.");
		}
		
		Node<E> aux = first;
		first = first.next;
		size--;
		return aux.value;
	}

	public E popLast() throws IllegalStateException {
		if (size == 0) {
			throw new IllegalStateException("Deque is empty.");
		} else if (size == 1) {
			return popFirst();
		} else {
			Node<E> aux = first;
			int counter = 0;
			while (counter < (size - 1)) {
				aux = aux.next;
				counter++;
			}
			E lastValue = last.value;
			last = aux;
			aux.next = null;
			return lastValue;
		}
	}

	public E getFirts() {
		return first.value;
	}

	public E getLast() {
		return last.value;
	}

}
