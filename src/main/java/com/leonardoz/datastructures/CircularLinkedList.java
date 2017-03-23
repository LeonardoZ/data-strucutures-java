package com.leonardoz.datastructures;

public class CircularLinkedList<E> implements LinkedList<E>  {

	static class Node<E> {
		E value = null;
		Node<E> next = null;
		
		Node(E value, Node<E> next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public CircularLinkedList() {
		this.first = null;
	}
	
	
	@Override
	public void insert(E value) { 
		if (size == 0) {
			first = new Node<>(value, null);
			last = first;
			first.next = last;
			last.next = first;
		} else {
			Node<E> newNode = new Node<>(value, first);
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	
	
	@Override
	public void insertAt(E value, int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		} 
		if (position == 0) {
			first = new Node<>(value, first);
			last = last == null ? first : last; 
		} else if (position == size) {
			Node<E> aux = last;
			Node<E> newNode = new Node<>(value, first);
			aux.next = newNode;
			last = newNode;
		} else {
			Node<E> aux = first.next;
			int counter = 1;
			while (counter < position - 1) {
				aux = aux.next;
				counter++;
			}
			Node<E> newNode = new Node<>(value, aux.next);
			aux.next = newNode;
		}
		size++;
	}
	
	
	@Override
	public E removeAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		}

		size--;
		if (position == 0) {
			Node<E> aux = first;
			first = first.next;
			last.next = first;
			return aux.value;
		} else if (position == (size - 1)) {
			Node<E> Node = getNode(position - 1);
			Node.next = first;
			Node<E> aux = last;
			last = Node;
			return aux.value;
		} else {
			Node<E> Node = getNode(position - 1);
			Node<E> removed = Node.next;
			Node.next = removed.next;
			return removed.value;
		}
	}
	
	
	@Override
	public E getAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		}
		return getNode(position).value;
	}

	public boolean ehCircular() {
		return first.value == last.next.value;
	}
	
	@Override
	public E getLast() {
		return last.value;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	
	private Node<E> getNode(int position) {
		if (position == 0) {
			return first;
		} else if (position == (size - 1)) {
			return last;
		} else {
			Node<E> aux = first.next;
			int counter = 1;
			while (counter <= position - 1 ) {
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
	
}
