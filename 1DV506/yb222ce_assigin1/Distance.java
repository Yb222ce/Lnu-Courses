package yb222ce_assigin1;
import java.util.Scanner;
public class Distance {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter x1: ");
		double x1 = input.nextDouble();

		System.out.print("Enter y1: ");
		double y1 = input.nextDouble();

		System.out.print("Enter x2: ");
		double x2 = input.nextDouble();

		System.out.print("Enter y2: ");
		double y2 = input.nextDouble();

		double distance;
		distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

		System.out.println("Distance = " + (int) (distance * 1000 + 0.005) / 1000.0);

		input.close();

	}


}
