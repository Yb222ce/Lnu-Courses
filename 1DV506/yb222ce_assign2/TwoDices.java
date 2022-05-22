package yb222ce_assign2;

import java.util.Random;

public class TwoDices {
	public static void main(String[] args) {

		System.out.println("Frequency table (sum,count) for rolling two dices 10000 times");
		int[] count = new int[11];

		Random random = new Random();

		for (int i = 1; i <= 10000; i++) {
			int random1 = random.nextInt(6) + 1;
			int random2 = random.nextInt(6) + 1;
			count[random1 + random2 - 2]++;

		}
		for (int i = 0; i < count.length; i++)

			System.out.println((i + 2) + "\t" + count[i]);
	}
}
