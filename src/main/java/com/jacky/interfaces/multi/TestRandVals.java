package com.jacky.interfaces.multi;

import java.util.Random;

interface RandVals {
	Random RAND =  new Random(47);
	
	int RANDOM_INT = RAND.nextInt(10);
	long RANDOM_LONG = RAND.nextLong() * 10;
	float RANDOM_FLOAT = RAND.nextFloat() * 10;
	double RANDOM_DOUBLE = RAND.nextDouble() * 10;
	
}

public class TestRandVals {


	public static void main(String[] args) {
		System.out.println(RandVals.RANDOM_INT);
		System.out.println(RandVals.RANDOM_LONG);
		System.out.println(RandVals.RANDOM_LONG);
		System.out.println(RandVals.RANDOM_FLOAT);
		System.out.println(RandVals.RANDOM_DOUBLE);
	}

}
