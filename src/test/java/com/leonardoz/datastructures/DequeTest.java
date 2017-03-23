package com.leonardoz.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leonardoz.datastructures.Deque;

public class DequeTest {

	@Test
	public void shouldInsertAtTheEnd() {
		Deque<Integer> deque = new Deque<>();
		deque.pushToEnd(10);
		deque.pushToEnd(5);
		deque.pushToEnd(1);
		assertEquals(1, deque.getLast().intValue());
	}

	@Test
	public void shouldInsertAtTheBeginning() {
		Deque<Integer> deque = new Deque<>();
		deque.pushToBeginning(10);
		deque.pushToBeginning(5);
		deque.pushToBeginning(1);
		assertEquals(1, deque.getFirts().intValue());
		assertEquals(10, deque.getLast().intValue());
	}

	@Test
	public void shouldConsumeFirst() {
		Deque<Integer> deque = new Deque<>();
		deque.pushToBeginning(10);
		deque.pushToBeginning(5);
		deque.pushToBeginning(1);
		assertEquals(1, deque.popFirst().intValue());
		assertEquals(5, deque.getFirts().intValue());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenConsumingAtTheEndInEmptyDeque() {
		Deque<Integer> deque = new Deque<>();
		assertEquals(1, deque.popLast().intValue());
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenConsumingAtTheBegenningInEmptyDeque() {
		Deque<Integer> deque = new Deque<>();
		assertEquals(1, deque.popFirst().intValue());
	}
	
	
	@Test
	public void shouldConsumeLast() {
		Deque<Integer> deque = new Deque<>();
		deque.pushToEnd(10);
		deque.pushToEnd(5);
		deque.pushToEnd(1);
		assertEquals(1, deque.popLast().intValue());
	}

}
