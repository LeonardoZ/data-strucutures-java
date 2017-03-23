package com.leonardoz.datastructures;

import com.leonardoz.datastructures.DoublyLinkedList;
import com.leonardoz.datastructures.LinkedList;

public class DoublyLinkedListTest extends LinkedListGenericTest {

	@Override
	public LinkedList<Integer> createLinkedList() {
		return new DoublyLinkedList<>();
	}
	


}
