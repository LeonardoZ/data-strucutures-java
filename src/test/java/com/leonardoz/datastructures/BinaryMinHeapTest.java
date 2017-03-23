package com.leonardoz.datastructures;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BinaryMinHeapTest {

	@Test
	public void shouldInsertCorrectly() {
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<>(Integer.class);
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(1);
		heap.insert(2);
		heap.insert(4);
		
		assertEquals(1, heap.min().intValue());
	}
	
	@Test
	public void shouldInsertCorrectlyAfterResize() {
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<>(Integer.class, 4);
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(1);
		heap.insert(2);
		heap.insert(4);
		
		assertEquals(1, heap.min().intValue());
	}
	
	

	@Test
	public void shouldPopTheMinValue() {
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<>(Integer.class);
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(1);
		heap.insert(2);
		heap.insert(4);
		
		assertEquals(1, heap.popMin().intValue());
		assertEquals(2, heap.popMin().intValue());
		assertEquals(4, heap.popMin().intValue());
		assertEquals(10, heap.popMin().intValue());
	}


}
