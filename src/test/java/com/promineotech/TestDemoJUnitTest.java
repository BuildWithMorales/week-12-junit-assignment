package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	} 
	
	/**
	 * Tests that addPositive correctly adds two positive numbers.
	 */
	@Test
	void assertThatAddPositiveWorksForTwoPositiveNumbers() {
		assertThat(testDemo.addPositive(5, 7)).isEqualTo(12);
	}

	/**
	 * Tests multiple scenarios for addPositive, including valid and invalid input.
	 */
	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);		
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
			    .isInstanceOf(IllegalArgumentException.class);
		} 
	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, 3, 0, true),
				arguments(3, -1, 0, true)
		);
	}

	/**
	 * Tests that multiplyPositive works for valid input and throws an exception for invalid input.
	 */
	@Test
	void assertThatMultiplyPositiveWorksForValidInput() {
		assertThat(testDemo.multiplyPositive(3, 4)).isEqualTo(12);
	}

	@Test
	void assertThatMultiplyPositiveThrowsExceptionForInvalidInput() {
		assertThatThrownBy(() -> testDemo.multiplyPositive(-3, 4))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Both numbers must be positive!");
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int result = mockDemo.randomNumberSquared();

		assertThat(result).isEqualTo(25);
	}
	
}
