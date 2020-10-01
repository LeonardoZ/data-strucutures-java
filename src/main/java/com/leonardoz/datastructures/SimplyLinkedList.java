package com.leonardoz.datastructures;

public class SimplyLinkedList<E> implements LinkedList<E>  {
	
// 	class to create a node of the linked list.
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
	
	public SimplyLinkedList() {
		this.first = null;
	}
	
	
	@Override
	public void insert(E value) { 
		if (size == 0) {
			first = new Node<>(value, null);
			last = first;
		} else {
			Node<E> newNode = new Node<>(value, null);
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	
// 	inserting the given 'value' at the given 'position'.
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
			Node<E> newNode = new Node<>(value, null);
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
	
// 	remove value from the given position of a linked list.
	@Override
	public E removeAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		}

		size--;
		if (position == 0) {
			Node<E> aux = first;
			first = first.next;
			return aux.value;
		} else if (position == (size - 1)) {
			// recupera o previous ao último
			Node<E> Node = getNode(position - 1);
			Node.next = null;
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
// 	returns the element from the given position.
	@Override
	public E getAt(int position) throws IllegalArgumentException {
		if (position > size) {
			throw new IllegalArgumentException("Illegal position. ");
		}
		return getNode(position).value;
	}
// 	returns the node of the given position
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
// returns the first element of the linked list.
	@Override
	public E getFirst() {
		return first.value;
	}
// 	returns the last elemetn of the linked list.
	@Override
	public E getLast() {
		return last.value;
	}
// returns the total number of nodes or length of the linked list.
	@Override
	public int getSize() {
		return size;
	}

	
}
