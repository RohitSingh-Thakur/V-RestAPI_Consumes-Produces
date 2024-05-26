package com.v.util;

import java.util.Random;

public class RandomeNumber {
	
	public static Integer getRandomeNumber() {
		Random random = new Random();
		return random.nextInt();
	}

}
