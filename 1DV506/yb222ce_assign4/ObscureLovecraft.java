package yb222ce_assign4;
import java.io.*;
import java.util.*;

public class ObscureLovecraft {
	public static void main(String[] args) {
		
			String ch;
			int ch1 = 0;
			try {
				File file = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV506/src/yb222ce_assign4/lovecraft.txt");
				File outFileObs = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV506/src/yb222ce_assign4/obscure.txt");
				File outFileRead = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV506/src/yb222ce_assign4/readableLovecraft.txt");
				Scanner sc = new Scanner(file);
				Scanner choice = new Scanner(System.in);

				do {
					System.out.println("Obscure");
					System.out.println("=======");
					System.out.println("1. Make obscure");
					System.out.println("2. Make readable");
					System.out.println("3. Print obscure");
					System.out.println("4. Print readable");
					System.out.println("0. Exit");
					System.out.println();
					System.out.println();
					System.out.print("==>");


					try {
						ch = choice.next();
						System.out.println("");
						if ((int) ch.charAt(0) >= 48 && (int) ch.charAt(0) <= 52 && ch.length() == 1)
						{
							ch1 = Integer.parseInt(ch);
							if (ch1 == 1) {
								PrintWriter printer = new PrintWriter(outFileObs);
								while (sc.hasNext()) {
									String str = sc.nextLine();
									for (int i = 0; i < str.length(); i++) {
										printer.print((char) (str.charAt(i) + 3));

									}
									printer.println();

								}
								System.out.println("Done!");
								printer.close();

							}
							if (ch1 == 2) {
								Scanner sc1 = new Scanner(outFileObs);
								PrintWriter printer = new PrintWriter(outFileRead);
								while (sc1.hasNext()) {
									String str = sc1.nextLine();
									for (int i = 0; i < str.length(); i++) {
										printer.print((char) (str.charAt(i) - 3));

									}
									printer.println();

								}
								System.out.println("Done!");
								printer.close();
								sc1.close();

							}
							if (ch1 == 3) {
								Scanner sc1 = new Scanner(outFileObs);
								while (sc1.hasNext()) {
									System.out.println(sc1.nextLine());
								}
								System.out.println("Done!");
								sc1.close();

							}
							if (ch1 == 4) {
								Scanner sc1 = new Scanner(outFileRead);
								while (sc1.hasNext()) {
									System.out.println(sc1.nextLine());
								}
								System.out.println("Done!");
								sc1.close();
							}
							if (ch1 == 0) {
								System.out.println("Bye, bye!");
								break;
							}

						} else {
							ch1 = 2;
									
							throw new InputMismatchException("That is not an option.");
						}
					}

					catch (InputMismatchException e) {
						System.out.println(e.getMessage());

					}

				} while (ch1 != 0);
				sc.close();
				choice.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
