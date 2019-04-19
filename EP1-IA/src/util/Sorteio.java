package util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sorteio {

	public static double sorteiaDouble(double max) {
		Random r = new Random();
		double randomValue = max  * r.nextDouble();
		return randomValue;
	}
	
	public static int sorteiaInt(int max) {
		int randomValue = ThreadLocalRandom.current().nextInt(0, max + 1);
		return randomValue;
	}
	
	public static void main(String[] args) {
		
	}
	
}
