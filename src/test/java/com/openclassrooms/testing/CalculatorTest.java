package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	
	private  Calculator calculator;
	
	private static Instant startedAt;
	
	@BeforeAll
	static public  void first() {
		System.out.println("Start des tests");
		startedAt = Instant.now();
	}
	

	@AfterAll
	static public void endTest() {
		System.out.println("fIN des tests");
		Instant endedAt = Instant.now();
		
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}
	
	@BeforeEach
	public void initCalculator() {
		System.out.println("Avant chaque Test");
		calculator = new Calculator();
	}
	
	@AfterEach
	public void closeCalculator() {
		System.out.println("APrés chaque Test");
		calculator = null;
	}

	@Test
	public void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;


		// Act
		int somme = calculator.add(a, b);

		// Assert
		assertEquals(5, somme);
	}

	@Test
	public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
		// Arrange
		int a = 42;
		int b = 11;

		// Act
		int produit = calculator.multiply(a, b);

		// Assert
		assertEquals(462, produit);
	}
	
	
	@ParameterizedTest(name = "{0} x 0 doit être égal à 0")
	@ValueSource(ints = { 1, 2, 42, 1011, 5089 })
	public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
		// Arrange -- Tout est prêt !

		// Act -- Multiplier par zéro
		int actualResult = calculator.multiply(arg, 0);

		// Assert -- ça vaut toujours zéro !
		assertEquals(0, actualResult);
	}
	
	
	@ParameterizedTest(name = "{0} + {1} should equal to {2}")
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
		// Arrange -- Tout est prêt !

		// Act
		int actualResult = calculator.add(arg1, arg2);

		// Assert
		assertEquals(expectResult, actualResult);
	}
	
	/**
	 * test addition et multiplication
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param expectResult
	 */
	
	@ParameterizedTest(name = "{0} + {1} should equal to {2}")
	@CsvSource({ "1,1,2,4", "2,3,5,25", "42,57,99,9801" })
	public void add_multi_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2,int arg3, int expectResult) {
		// Arrange -- Tout est prêt ! 

		// Act
		int result = calculator.add(arg1, arg2);
		
		int actualResult = calculator.multiply(result, arg3);

		// Assert
		assertEquals(expectResult, actualResult);
	}
	
	
	@Timeout(3)
	@Test
	public void longCalcul_shouldComputeInLessThan1Second() {
		// Arrange

		// Act
		calculator.longCalculation();
		
		// Assert
		// ...
	}


}
