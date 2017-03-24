package com.leonardoz.datastructures;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class BinaryMinHeap<T extends Comparable<T>> {

	private static final int FIRST_INDEX = 1;
	private T[] elements;
	private int capacity;
	private int heapSize;
	private Class<T> clazz;

	public BinaryMinHeap(Class<T> clazz) {
		this(clazz, 11);
	}

	public BinaryMinHeap(Class<T> clazz, int capacity) {
		this.clazz = clazz;
		this.capacity = capacity;
		this.heapSize = 1;
		this.elements = (T[]) Array.newInstance(clazz, capacity);
		// first element should not change
		this.elements[0] = null;
	}

	public void insert(T element) {
		if (capacity == heapSize) {
			if (heapSize == capacity) {
				capacity *= 2;
				T[] resizedElements = (T[]) Array.newInstance(clazz, capacity);
				for (int i = 0; i < heapSize; i++) {
					resizedElements[i] = elements[i];
				}
				elements = resizedElements;
			}
		}

		heapSize++;
		int finalPos = heapSize - 1;
		elements[finalPos] = element;

		// bubble-up
		// swap if child is minor then parent
		bubbleUp(finalPos);
	}

	private void bubbleUp(int i) {
		if (i == 1)
			return;
		T element = elements[i];
		int parentPos = getParent(i);
		T parent = elements[parentPos];
		if (parent == null)
			return;
		boolean less = element.compareTo(parent) == -1;
		if (less) {
			// swap parent by child
			elements[parentPos] = element;
			elements[i] = parent;
			bubbleUp(getParent(i));
		}
	}

	public T popMin() {
		if (heapSize == 1)
			return null;
		T minor = elements[FIRST_INDEX];

		int lastPos = heapSize - 1;

		// last goes first
		T toSwap = elements[lastPos];
		elements[FIRST_INDEX] = toSwap;
		elements[lastPos] = null;

		heapSize--;
		sinkDown(FIRST_INDEX);
		return minor;
	}

	private void sinkDown(int pos) {
		int smallest = pos;
		int left = getLeft(pos);
		if (left < heapSize) {
			boolean leftLessThan = elements[smallest].compareTo(elements[left]) == 1;
			if (leftLessThan)
				smallest = left;
		}

		int right = getRight(pos);
		if (right < heapSize) {
			boolean rightLessThan = elements[smallest].compareTo(elements[right]) == 1;
			if (rightLessThan)
				smallest = right;
		}

		if (smallest != pos) {
			// parent is bigger than child
			T toSwap = elements[pos];
			T aux = elements[smallest];
			elements[smallest] = toSwap;
			elements[pos] = aux;
			sinkDown(smallest);
		}
	}

	private int getParent(int i) {
		return i / 2;
	}

	private int getLeft(int i) {
		return (2 * i);
	}

	private int getRight(int i) {
		return (2 * i) + 1;
	}

	public T min() {
		return elements.length > 1 ? elements[1] : null;
	}

}
