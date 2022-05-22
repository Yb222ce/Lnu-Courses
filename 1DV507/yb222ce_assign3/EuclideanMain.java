package yb222ce_assign3;

public class EuclideanMain {
	private static int GCD(int A, int B) {
		if (B == 0) {
			return A;
		}

		if (A < B) {
			int temp = A;
			A = B;
			B = temp;
		}

		return GCD(B, A % B);
	}

	public static void main(String[] args) {
		System.out.println("GCD : " + GCD(18, 12));
		System.out.println("GCD : " + GCD(42, 56));
		System.out.println("GCD : " + GCD(9, 28));
	}

}
