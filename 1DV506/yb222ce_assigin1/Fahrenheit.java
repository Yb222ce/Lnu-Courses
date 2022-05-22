package yb222ce_assigin1;

public class Fahrenheit {
	public static void main(String[] args) {

		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.print("Enter The Fahrenheit temperatur: ");
		float fahrenheit = scan.nextFloat();
		float celsius = (fahrenheit - 32) * 5 / 9;

		System.out.print("The Celsius temperatur is :  " + celsius);
		
		scan.close();

	}
}
