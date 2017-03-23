package com.leonardoz.datastructures;

import java.lang.reflect.Array;

/*
 * Queue
 * FIFO
 */
@SuppressWarnings("unchecked")
public class Queue<E> {
	
	private Class<E> clazz;
	private E[] elements;
	private int head, capacity, index;

	public Queue(Class<E> clazz) {
		this.clazz = clazz;
		this.capacity = 10;
		this.head = -1;
		this.index = -1;
		this.elements = (E[]) Array.newInstance(clazz, capacity);
	}

	public Queue(Class<E> clazz, int capacity) {
		this(clazz);
		this.capacity = capacity;
		this.elements = (E[]) Array.newInstance(clazz, capacity);
		
	}

	public void enqueue(E element){
		if ((index + 1) == capacity) {
			capacity *= 2;
			E[] resizedNodes = (E[]) Array.newInstance(clazz, capacity);
			for (int i = 0; i <= index; i++) {
				resizedNodes[i] = elements[i];
			}
			elements = resizedNodes;
		}
		if (head == -1) {
			head++;
		}
		elements[++index] = element;
	}
	
	public E dequeue() throws IllegalStateException {
		if (index == -1) {
			throw new IllegalStateException("The Queue is empty.");
		}
		E retirado = elements[head];
		
		elements[head] =  null;
		if (head <= index) {
			head++;
			index--;
		} else {
			head = -1;
			index = -1;
		} 
		return retirado;
	}
	
	public int size(){
		return index + 1;
	}
	
}
