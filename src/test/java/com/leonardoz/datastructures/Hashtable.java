package com.leonardoz.datastructures;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class Hashtable<K, V> {

	static class Element<K, V> {
		K key;
		V value;

		Element(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	private int tableSize, tableCount;
	private Element<K, V>[] table;

	public Hashtable(int tableSize) {
		this.tableSize = nextPrime(31);
		this.table = (Element[]) Array.newInstance(Element.class, tableSize);
	}

	public void put(K key, V value) {
		if (tableCount == tableSize) {
			throw new IllegalStateException("Hashtable is empty");
		}

		Element<K, V> element = new Element<>(key, value);
		table[hash(key)] = element;
		tableCount++;
	}

	int nextPrime(int n) {
		int i = n;
		for (; i < 2 * n; ++i) {
			// go with your regular prime checking routine
			// as soon as you find a prime, break this for loop
			if (isPrime(i))
				return i;
		}
		return n;
	}

	boolean isPrime(int n) {
		return false;
	}

	public void runEratosthenesSieve(int upperBound) {
		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
		boolean[] isComposite = new boolean[upperBound + 1];
		for (int m = 2; m <= upperBoundSquareRoot; m++) {
			if (!isComposite[m]) {
				System.out.print(m + " ");
				for (int k = m * m; k <= upperBound; k += m)
					isComposite[k] = true;
			}
		}
		for (int m = upperBoundSquareRoot; m <= upperBound; m++)
			if (!isComposite[m])
				System.out.print(m + " ");
	}

	/*
	 * https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/st-hash.html
	 */
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % tableSize;
	}

}
