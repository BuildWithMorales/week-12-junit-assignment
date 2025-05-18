package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}
	/**
	 * Multiplies two positive integers. If either number is 0 or negative,
	 * it throws an IllegalArgumentException.
	 * @param a the first positive integer
	 * @param b the second positive integer
	 * @return the product of a and b
	 * @throws IllegalArgumentException if either number is not positive 
	 */
	public int multiplyPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both numbers must be positive!");
		}
	 return a * b;
} 
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num * num;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
