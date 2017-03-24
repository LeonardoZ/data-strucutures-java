package com.leonardoz.datastructures;

import org.junit.Test;

public class HashtableTest {

	@Test
	public void shouldPutValue() {
		Hashtable<Integer, Integer> hashtable = new Hashtable<>(10);
		hashtable.put(1, 1992);
		hashtable.put(2, 1996);
		hashtable.put(3, 1969);
		hashtable.put(4, 1969);
		hashtable.runEratosthenesSieve(62);
	}

}
