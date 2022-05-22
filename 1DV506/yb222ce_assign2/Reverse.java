package yb222ce_assign2;

public class Reverse {
	public static void main(String[] args) {
		char[] text = { '!', 'y', 's', 'a', 'E', ' ', 's', 'a', 'w', ' ', 's', 'i', 'h', 'T' };

		// It first prints the content of the array text in one line.
		System.out.println(text);

		// Reorder the array elements backwards (in opposite order)
		char[] text2 = new char[text.length];

		for (int i = text.length - 1, n = 0; i >= 0 && n < text.length; n++, i--) {
			text2[n] = text[i];
		}
		System.out.println(text2);
	}

}
