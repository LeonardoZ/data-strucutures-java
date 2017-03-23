package com.leonardoz.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.leonardoz.datastructures.DynamicArray;

public class DynamicArrayTest {

	@Test
	public void testDeveInserirNoFinal() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		Integer Node = 999;
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.insertAt(numbers, Node, 6);
		assertEquals(7, newNumbers.length);
		assertEquals(Node, newNumbers[6]);
	}
	
	@Test
	public void testDeveInserirEmPrimeiro() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		Integer Node = 999;
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.insertAt(numbers, Node, 0);
		assertEquals(7, newNumbers.length);
		assertEquals(Node, newNumbers[0]);
	}
	
	@Test
	public void testInserirNoMeio() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		Integer Node = 999;
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.insertAt(numbers, Node, 2);
		assertEquals(7, newNumbers.length);
		assertEquals(Node, newNumbers[2]);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testDeveLancarExceptionAoInserir() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		Integer Node = 999;
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		array.insertAt(numbers, Node, 8);
	}
	
	@Test
	public void testDeveRemoverUltimo() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.removeAt(numbers, 5);
		assertEquals(5, newNumbers.length);
		assertTrue(newNumbers[4] == 4);
	}
	
	@Test
	public void testDeveRemoverPrimeiro() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.removeAt(numbers, 0);
		assertEquals(5, newNumbers.length);
		assertTrue(newNumbers[0] == 1);
	}
	
	@Test
	public void testDeveRemoveOTerceiro() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5};
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.removeAt(numbers, 2);
		assertEquals(5, newNumbers.length);
		assertTrue(newNumbers[2] == 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLancarExceptionIllegal() {
		Integer[] numbers = {};
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		Integer[] newNumbers = array.removeAt(numbers, 2);
		assertEquals(5, newNumbers.length);
		assertTrue(newNumbers[2] == 3);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testLancarExceptionIndexOut() {
		Integer[] numbers = {1, 2, 3, 5};
		DynamicArray<Integer> array = new DynamicArray<Integer>(Integer.class);
		array.removeAt(numbers, 7);
	}
	
}
