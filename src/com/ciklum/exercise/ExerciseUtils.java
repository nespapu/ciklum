package com.ciklum.exercise;

import java.util.Random;

public class ExerciseUtils {

	public static String getRandomPositiveInteger(Integer length, Integer top) {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for(int i=0; i<length; i++) {
			builder.append(random.nextInt(top));
		}
		return builder.toString();
	}
	
	//With top = 35 -> alphanumerics
	//With top = 25 -> just chars
	public static String getRandomAlphanumericString(Integer length, Integer top) {
		String alphanumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        char c;
        int j;
        for(int i=0; i<length; i++) {
        	j = random.nextInt(top);
        	c = alphanumerics.charAt(j);
        	builder.append(c);
        }
        return builder.toString();
	}
}
