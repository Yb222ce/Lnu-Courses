package yb222ce_assigin1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WindChill {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Temperature (C): ");
		double t = scan.nextDouble();

		System.out.print("Wind speed (m/s): ");
		double v = scan.nextDouble();

		double v1 = v * 18 / 5;
        double twc = 13.12 + 0.6215 * t - 11.37 * Math.pow(v1, 0.16) + 0.3965 * t * Math.pow(v1, 0.16);

		DecimalFormat speedFormat = new DecimalFormat("0.#");
		String twc2 = speedFormat.format(twc);

		System.out.println("\nWind Chill Temperature (C): " + twc2);
		
		scan.close();
	}


}
