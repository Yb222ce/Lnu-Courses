package yb222ce_assigin1;
import java.util.Scanner;
public class Interest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Initial savings : ");
		double s = scan.nextDouble();
		System.out.print("Enter Interest rate : ");
		double p = scan.nextDouble();
		double amount = s * Math.pow(1 + p / 100, 5);

		amount = Math.round(amount);
		System.out.print("The value of your savings after 5 years is: " +(int) amount);

		scan.close();

	}
}
