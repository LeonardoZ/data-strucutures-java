package com.leonardoz.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leonardoz.datastructures.LinkedList;

public abstract class LinkedListGenericTest {

	public abstract LinkedList<Integer> createLinkedList();
	
	@Test
	public void lastShouldBeEqualToFirst() {
		LinkedList<Integer> list = createLinkedList();
		list.insert(10);
		assertEquals(list.getLast(), list.getFirst());
	}

	@Test
	public void lastShouldBeEqualToFirstWhenInsertingAt() {
		LinkedList<Integer> list = createLinkedList();
		list.insertAt(10, 0);
		assertEquals(list.getLast(), list.getFirst());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsExeptionWhenInsertingAtIllegalPosition() {
		LinkedList<Integer> list = createLinkedList();
		list.insertAt(10, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsExeptionWhenGettingAtIllegalPosition() {
		LinkedList<Integer> list = createLinkedList();
		list.getAt(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsExeptionWhenRemovingAtIllegalPosition() {
		LinkedList<Integer> list = createLinkedList();
		list.removeAt(2);
	}

	@Test
	public void shouldInsert30AtTheEnd() {
		LinkedList<Integer> list = createLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		assertEquals(30, list.getLast().intValue());
		assertEquals(3, list.getSize());
	}

	@Test
	public void shouldInsertAtFirstPosition() {
		LinkedList<Integer> list = listWith5Nodes();
		list.insertAt(5, 0);
		assertEquals(5, list.getAt(0).intValue());
		assertEquals(10, list.getAt(1).intValue());
		assertEquals(20, list.getAt(2).intValue());
		assertEquals(30, list.getAt(3).intValue());
		assertEquals(40, list.getAt(4).intValue());
		assertEquals(50, list.getAt(5).intValue());
	}

	@Test
	public void shouldInsertAtTheEnd() {
		LinkedList<Integer> list = listWith5Nodes();
		list.insertAt(60, 5);
		assertEquals(10, list.getAt(0).intValue());
		assertEquals(20, list.getAt(1).intValue());
		assertEquals(30, list.getAt(2).intValue());
		assertEquals(40, list.getAt(3).intValue());
		assertEquals(50, list.getAt(4).intValue());
		assertEquals(60, list.getAt(5).intValue());
	}

	@Test
	public void shouldInsertAt3rdPosition() {
		LinkedList<Integer> list = listWith5Nodes();
		list.insertAt(35, 3);
		assertEquals(10, list.getAt(0).intValue());
		assertEquals(20, list.getAt(1).intValue());
		assertEquals(30, list.getAt(2).intValue());
		assertEquals(35, list.getAt(3).intValue());
		assertEquals(40, list.getAt(4).intValue());
		assertEquals(50, list.getAt(5).intValue());
	}

	@Test
	public void shouldInsert10AtTheEnd() {
		LinkedList<Integer> list = createLinkedList();
		list.insert(10);
		assertEquals(10, list.getLast().intValue());
		assertEquals(1, list.getSize());
	}


	@Test
	public void shouldRemoveFirst() {
		LinkedList<Integer> list = listWith5Nodes();
		Integer removed = list.removeAt(0);
		assertEquals(10, removed.intValue());
	}

	@Test
	public void shouldRemoveThird() {
		LinkedList<Integer> list = listWith5Nodes();
		Integer removed = list.removeAt(2);
		assertEquals(30, removed.intValue());
	}

	@Test
	public void shouldGetFirst() {
		LinkedList<Integer> list = listWith5Nodes();
		Integer found = list.getAt(0);
		assertEquals(10, found.intValue());
	}

	@Test
	public void shouldGetFirstWithSingleNodeList() {
		LinkedList<Integer> list = createLinkedList();
		list.insert(10);
		Integer found = list.getAt(0);
		assertEquals(10, found.intValue());
	}

	@Test
	public void shouldGetFirstWithDoubleNodeList() {
		LinkedList<Integer> list = createLinkedList();
		list.insert(10);
		list.insert(20);
		Integer found = list.getAt(1);
		assertEquals(20, found.intValue());
	}

	@Test
	public void shouldReturnFourth() {
		LinkedList<Integer> list = listWith5Nodes();
		Integer found = list.getAt(3);
		assertEquals(40, found.intValue());
	}

	@Test
	public void shouldReturnLast() {
		LinkedList<Integer> list = listWith5Nodes();
		Integer found = list.getAt(4);

		assertEquals(50, found.intValue());
	}

	private LinkedList<Integer> listWith5Nodes() {
		LinkedList<Integer> list = createLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		return list;
	}

}
