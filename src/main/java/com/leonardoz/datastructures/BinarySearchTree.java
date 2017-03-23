package com.leonardoz.datastructures;

/*
 * No duplicates.
 * "Ordered".
 */
public class BinarySearchTree<E extends Comparable<E>> {

	static class Vertex<E extends Comparable<E>> {
		Vertex<E> left, right;
		E value;

		public Vertex(Vertex<E> left, Vertex<E> right, E value) {
			super();
			this.left = left;
			this.right = right;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
	}

	private Vertex<E> root;

	public int height() {
		return recursiveHeight(root);
	}

	private int recursiveHeight(Vertex<E> vertex) {
		if (vertex == null)
			return 0;
		return 1 + Math.max(recursiveHeight(vertex.left), recursiveHeight(vertex.right));
	}

	public int depth(E value) {
		if (root == null)
			return 0;
		int i = 1;
		return recursiveDepth(value, root, i);
	}

	private int recursiveDepth(E value, Vertex<E> vertex, int counter) {
		if (vertex == null) {
			return -1;
		}
		int compared = value.compareTo(vertex.value);
		if (compared == -1) {
			return recursiveDepth(value, vertex.left, counter + 1);
		} else if (compared == 1) {
			return recursiveDepth(value, vertex.right, counter + 1);
		} else if (compared == 0) {
			return counter;
		}
		return -1;
	}

	public E search(E value) {
		if (root == null) {
			return null;
		}

		return buscarRecursivo(value, root);
	}

	private E buscarRecursivo(E value, Vertex<E> vertex) {
		if (vertex == null) {
			return null;
		}
		int comparado = value.compareTo(vertex.value);
		if (comparado == -1) {
			return buscarRecursivo(value, vertex.left);
		} else if (comparado == 1) {
			return buscarRecursivo(value, vertex.right);
		} else if (comparado == 0) {
			return vertex.value;
		}
		return value;
	}

	public void insert(E value) {
		if (root == null) {
			root = new Vertex<>(null, null, value);
		} else {
			adicionarRecursivo(value, root);
		}
	}

	private void adicionarRecursivo(E value, Vertex<E> vertex) {
		int comparado = value.compareTo(vertex.value);
		if (comparado == -1) {
			// left
			if (vertex.left != null) {
				adicionarRecursivo(value, vertex.left);
			} else {
				vertex.left = new Vertex<>(null, null, value);
			}
		} else if (comparado == 1) {
			// right
			if (vertex.right != null) {
				adicionarRecursivo(value, vertex.right);
			} else {
				vertex.right = new Vertex<>(null, null, value);
			}
		}
	}

	public boolean remove(E value) {
		if (root == null) {
			return false;
		} else {
			root = removerRecursivo(value, root);
			return true;
		}
	}

	private Vertex<E> removerRecursivo(E value, Vertex<E> vertex) {
		if (vertex == null) {
			return null;
		}

		int comparado = value.compareTo(vertex.value);
		if (comparado == -1) {
			// left
			root.left = removerRecursivo(value, vertex.left);
		} else if (comparado == 1) {
			// right
			root.right = removerRecursivo(value, vertex.right);
		} else {
			// vertex tem 2 filhos
			if (vertex.left != null && vertex.right != null) {
				// pega o menor da árvore right
				vertex.value = findMinor(vertex.right).value;
				// remove o value pego da árvore right
				vertex.right = removerRecursivo(vertex.value, vertex.right);
			} else {
                vertex = ( vertex.left != null ) ? vertex.left: vertex.right;
			}
		}
		return vertex;
	}

	private Vertex<E> findMinor(Vertex<E> vertex) {
		if (vertex == null)
			return null;
		else if (vertex.left == null)
			return vertex;
		return findMinor(vertex.left);
	}

	public E getRaiz() {
		return root.value;
	}

}
