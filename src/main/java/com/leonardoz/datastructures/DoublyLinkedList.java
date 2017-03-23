package com.leonardoz.datastructures;

public class DoublyLinkedList<E> implements LinkedList<E> {

	static class Node<E> {
		E value = null;
		Node<E> next = null;
		Node<E> previous = null;

		Node(E value, Node<E> previous, Node<E> next) {
			super();
			this.value = value;
			this.previous = previous;
			this.next = next;

		}
	}

	private Node<E> first;
	private Node<E> last;
	private int size;

	public DoublyLinkedList() {
		this.first = null;
	}

	public void insert(E value) {
		if (first == null) {
			first = new Node<>(value, null, null);
			last = first;
		} else {
			Node<E> newNode = new Node<>(value, last, null);
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	public void insertAt(E value, int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position.");
		}
		if (position == 0) {
			// inicio
			first = new Node<>(value, null, first);
			last = last == null ? first : last;
		} else if (position == size) {
			// Fim
			Node<E> aux = last;
			Node<E> newNode = new Node<>(value, last, null);
			aux.next = newNode;
			last = newNode;
		} else {
			// Meio
			Node<E> aux = first.next;
			int counter = 1;
			// acha o previous ao procurado, o n-1
			while (counter < position - 1) {
				aux = aux.next;
				counter++;
			}
			Node<E> newNode = new Node<>(value, aux, aux.next);
			aux.next = newNode;
		}
		size++;
	}

	public E removeAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position.");
		}

		size--;
		if (position == 0) {
			Node<E> aux = first;
			first = first.next;
			return aux.value;
		} else if (position == (size - 1)) {
			// recupera o previous ao último
			Node<E> element = last.next;
			element.next = null;
			Node<E> aux = last;
			last = element;
			return aux.value;
		} else {
			Node<E> removed = getNode(position);
			Node<E> element = removed.next;
			element.next = removed.next;
			return removed.value;
		}
	}

	public E getAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position.");
		}
		return getNode(position).value;
	}

	private Node<E> getNode(int position) {
		if (position == 0) {
			// inicio
			return first;
		} else if (position == (size - 1)) {
			// Fim
			return last;
		} else {
			// Meio
			Node<E> aux = first.next;
			int counter = 1;
			// acha o previous ao procurado, o n-1
			while (counter <= position - 1) {
				aux = aux.next;
				counter++;
			}
			return aux;
		}
	}

	@Override
	public E getFirst() {
		return first.value;
	}

	public E getLast() {
		return last.value;
	}

	public int getSize() {
		return size;
	}


}
