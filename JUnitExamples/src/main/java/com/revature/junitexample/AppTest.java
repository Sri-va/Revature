package com.revature.junitexample;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Checking")
public class AppTest {
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before each");
	}
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before all");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After Each");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After all");
	}
	
	@Test
	void testOne() {
		System.out.println("Test One Executed");
		Assertions.assertEquals(4, Calculator.add(2, 2));
	}
}
