package com.leonardoz.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leonardoz.datastructures.Queue;

public class QueueTest {

	@Test
	public void shouldEnqueue() {
		Queue<Integer> queue = new Queue<>(Integer.class);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(2, queue.size());
	}
	
	@Test
	public void shouldEnqueueAndThenDequeue() {
		Queue<Integer> queue = new Queue<>(Integer.class);
		queue.enqueue(1);
		queue.enqueue(2);
		
		Integer taken = queue.dequeue();
		assertEquals(1, taken.intValue());
		assertEquals(1, queue.size());

		Integer taken2 = queue.dequeue();
		assertEquals(2, taken2.intValue());
		assertEquals(0, queue.size());
	}
	
	@Test
	public void deveEnfileirarERetirarComCapacidade() {
		Queue<Integer> queue = new Queue<>(Integer.class, 2);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Integer taken = queue.dequeue();
		assertEquals(1, taken.intValue());
		assertEquals(2, queue.size());

		Integer taken2 = queue.dequeue();
		assertEquals(2, taken2.intValue());
		assertEquals(1, queue.size());

	}
	
	@Test
	public void shouldEnqueueMantainingExactlyCapacity() {
		Queue<Integer> queue = new Queue<>(Integer.class, 2);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		Integer taken = queue.dequeue();
		assertEquals(1, taken.intValue());
		assertEquals(2, queue.size());

		Integer taken2 = queue.dequeue();
		assertEquals(2, taken2.intValue());
		assertEquals(1, queue.size());
		
		Integer taken3 = queue.dequeue();
		assertEquals(3, taken3.intValue());
		assertEquals(0, queue.size());
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionOnEmptyDequeue() {
		Queue<Integer> queue = new Queue<>(Integer.class, 2);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

}
