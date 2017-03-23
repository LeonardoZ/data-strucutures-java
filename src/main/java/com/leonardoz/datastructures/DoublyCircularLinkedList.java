package com.leonardoz.datastructures;

public class DoublyCircularLinkedList<E> implements LinkedList<E> {

	static class Node<E> {
		E value = null;
		Node<E> previous = null;
		Node<E> next = null;
		
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
	
	public DoublyCircularLinkedList() {
		this.first = null;
	}
	
	public void insert(E value) { 
		if (size == 0) {
			first = new Node<>(value, null, null);
			last = first;
			first.next = first;
			first.previous = last;
			last.next = first;
		} else {
			Node<E> newNode = new Node<>(value, last, first);
			last.next = newNode;
			last = newNode;
			first.previous = last;
		}
		size++;
		
	}
	
	public void insertAt(E value, int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		} 
		if (position == 0) {
			first = new Node<>(value, last, first);
			last = last == null ? first : last;
			last.previous = first;
		} else if (position == size) {
			Node<E> aux = last;
			Node<E> newNode = new Node<>(value, last, first);
			aux.next = newNode;
			last = newNode;
			first.previous = last;
		} else {
			Node<E> aux = first.next;
			int counter = 1;
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
			throw new IllegalArgumentException("Illegal position. ");
		}
		if (position == 0) {
			Node<E> aux = first;
			first = first.next;
			last.next = first;
			return aux.value;
		} else if (position == (size - 1)) {
			// recupera o previous ao último
			Node<E> Node = last.previous;
			Node.next = null;
			Node<E> aux = last;
			last = Node;
			first.previous = last;
			return aux.value;
		} else {
			Node<E> removed = getNode(position);
			Node<E> Node = removed.previous;
			Node.next = removed.next;
			return removed.value;
		}
	}
	
	public E getAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		}
		return getNode(position).value;
	}

	public E getLast() {
		return last.value;	
	}
	
	public int getSize() {
		return size;
	}
	
	
	public boolean isCyclic() {
		return first.value == last.next.value && first.previous.value == last.value;
	}
	
	public void print(){
		Node<E> aux = first;
		while (aux != null) {
			aux = aux.next;
		}
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
