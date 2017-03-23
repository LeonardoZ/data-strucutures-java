package com.leonardoz.datastructures;

public class MatrixOperations {
	
	public Integer[][] transpose(Integer[][] matrix) {
		Integer[][] result = new Integer[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result[j][i] = matrix[i][j];
			}
		}
		return result;
	}
	
	public Integer[][] sum(Integer[][] matrixA, Integer[][] matrixB) throws IllegalArgumentException {
		if (!sameOrderMatrix(matrixA, matrixB)) {
			throw new IllegalArgumentException("Matrix should have the same order.");
		}
		Integer[][] result = new Integer[matrixA.length][matrixB.length];
		
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				result[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		
		return result;
	}
	
	public boolean sameOrderMatrix(Integer[][] matrixA, Integer[][] matrixB) {
		int counterLineA = matrixA.length, counterColumnA = matrixA[0].length;
		int counterLineB = matrixB.length, counterColumnB = matrixB[0].length;
		return counterLineA == counterLineB &&
			   counterColumnA == counterColumnB;
	}
	
}
