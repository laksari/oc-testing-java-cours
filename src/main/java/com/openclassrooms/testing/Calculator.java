package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public void longCalculation() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Set<Integer> digitsSet(int number) {
		
		Set<Integer> setNombre = new HashSet<Integer>();
		
		String nombre = String.valueOf(number);
		
		for(int i =0; i<nombre.length();i++) {
			setNombre.add( Integer.parseInt(nombre.substring(i, i+1)) );
		}
		
		return setNombre;
	}

}
