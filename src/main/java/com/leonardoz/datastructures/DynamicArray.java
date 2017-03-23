package com.leonardoz.datastructures;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class DynamicArray<E> {

	private Class<E> clazz;
	private int capacity;
	
	public DynamicArray(Class<E> clazz) {
		this.clazz = clazz;
		this.capacity = 10;
	}
	public DynamicArray(Class<E> clazz, int capacity) {
		this.clazz = clazz;
		this.capacity = capacity;
	}
	
	public E[] insertAt(E[] array, E element, int index) throws ArrayIndexOutOfBoundsException {
		if ((index + 1) == capacity) {
			capacity *= 2;
			E[] resizedElements = (E[]) Array.newInstance(clazz, capacity);
			for (int i = 0; i <= index; i++) {
				resizedElements[i] = array[i];
			}
			array = resizedElements;
		}
		
		int newLength = array.length + 1; 
		E[] newElements = (E[]) Array.newInstance(clazz, newLength);

		for (int i = 0; i <= index; i++) {
			if (i == index) {
				newElements[i] = element;
			} else {
				newElements[i] = array[i];
			}
		}
		
		for (int i = index + 1; i < newLength; i++) {
			newElements[i] = array[i - 1];
		}
		
		return newElements;
	}
	
	public E[] removeAt(E[] array, int index) throws ArrayIndexOutOfBoundsException,
														    IllegalArgumentException {
		if (array.length == 0) {
			throw new IllegalArgumentException("Array is empty.");
		}
		int newElementSize = array.length - 1;
		
		E[] newElement = (E[]) Array.newInstance(clazz, newElementSize);
		
		for (int i = 0; i < index; i++) {
			newElement[i] = array[i];
		}
		
		for (int i = index + 1; i < array.length - 1; i++) {
			newElement[i - 1] = array[i];
		}
		
		return newElement;
	}

}
