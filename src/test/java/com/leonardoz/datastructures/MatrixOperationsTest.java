package com.leonardoz.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leonardoz.datastructures.MatrixOperations;

public class MatrixOperationsTest {

	@Test
	public void shouldHaveTheSameOrderTest() {
		MatrixOperations matrixOperations = new MatrixOperations();
		Integer[][] A = {
						 {2, 3, 4},
						 {4, 5, 6},
						 {1, 1, 0}
						};
		Integer[][] B = {
						 {1, 2, 4},
						 {8, 1, 2},
						 {9, 0, 1}
						};
		
		assertTrue(matrixOperations.sameOrderMatrix(A, B));
	}
	
	@Test
	public void shouldNotHaveTheSameOrder() {
		MatrixOperations matrixOperations = new MatrixOperations();
		Integer[][] A = {
						 {2, 3, 4},
						 {4, 5, 6},
						 {1, 1, 0}
						};
		Integer[][] B = {
						 {1, 2, 4},
						 {8, 1, 2}
						};
		
		assertFalse(matrixOperations.sameOrderMatrix(A, B));
	}
	
	@Test
	public void shouldSumCorrectly() {
		MatrixOperations matrixOperations = new MatrixOperations();
		Integer[][] A = {
						 {2, 3, 4},
						 {4, 5, 6},
						 {1, 1, 0}
						};
		Integer[][] B = {
						 {1, 2, 4},
						 {8, 1, 2}, 
						 {9, 0, 1}
						};
		
		Integer[][] AB = {
						  {3, 5, 8},
						  {12, 6, 8},
						  {10, 1, 1}, 
						 };
		assertArrayEquals(AB, matrixOperations.sum(A, B));
	}
	
	@Test
	public void shouldTransposeCorrectly() {
		MatrixOperations matrixOperations = new MatrixOperations();
		Integer[][] matrix = 
						{
						 {2, 3, 4},
						 {4, 5, 6}
						};
		Integer[][] transposed = 
						{
						 {2, 4},
						 {3, 5},
						 {4, 6}
						};

		assertArrayEquals(transposed, matrixOperations.transpose(matrix));
	}
	
}
