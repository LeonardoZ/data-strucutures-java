package com.leonardoz.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.leonardoz.datastructures.BinarySearchTree;

public class BinarySearchTreeTest {

	@Test
	public void shouldAddAndFindVertex() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.insert(20);
		tree.insert(-1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		
		assertEquals(5, tree.search(5).intValue());
		assertEquals(20, tree.search(20).intValue());
		assertEquals(10, tree.search(10).intValue());
	}
	
	@Test
	public void depthShouldBe2() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		
		assertEquals(2, tree.depth(20));
	}
	
	@Test
	public void depthShouldBe4() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.insert(4);
		tree.insert(40);
		tree.insert(2);
		tree.insert(60);
		
		assertEquals(3, tree.depth(4));
	}
	
	@Test
	public void heigthShouldBe2() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		
		assertEquals(2, tree.height());
	}
	
	@Test
	public void shouldRemove5() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		
		assertTrue(tree.remove(5));
		assertEquals(null, tree.search(5));
	}
	
	@Test
	public void shouldRemove5AndPromote() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.insert(3);
		tree.insert(2);
		tree.insert(25);
		tree.insert(30);
		assertTrue(tree.remove(5));
		assertEquals(null, tree.search(5));
	}
	

}
