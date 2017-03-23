package com.leonardoz.datastructures;

public interface LinkedList<E> {

	void insert(E value);

	void insertAt(E value, int position) throws IllegalArgumentException;

	E removeAt(int position) throws IllegalArgumentException;

	E getAt(int position) throws IllegalArgumentException;
	
	E getFirst();
	
	E getLast();

	int getSize();

}