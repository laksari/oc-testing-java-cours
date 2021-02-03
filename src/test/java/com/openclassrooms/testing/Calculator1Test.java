package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Calculator1Test {

	@Test
	void testAddNumber() {
		int a = 2;
		int b = 3;
		Calculator calculator = new Calculator();
		
		int somme = calculator.add(a, b);
		
		assertEquals(5, somme);
				
	}

}
