import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		start();
	}
	public static void start(){
		boolean restart = false;
		userName();
		Level Level = new Level();
		Hangman hangman;

		do {
			hangman = new Hangman();
			while (hangman.play()) {
				int input = hangman.gamelist();

				switch (input) {
					case 1:
						restart = Level.playGameEasy();
						break;
					case 2:
						restart = Level.playGameMedium();
						break;
					case 3:
						restart = Level.playGameHard();
						break;
					case 4:
						hangman.endtheGame();
						System.out.println("You revealed " + Level.count + " unknown words");

						break;

					default:
						System.out.println("Incorrect number\n");
						break;
				}
			}
		} while (restart);
	}
	public static void userName(){
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.println("Enter a name to continue: (only English letters or integers)");
		name = sc.nextLine();
		while (!name.matches("[a-zA-Z0-9]+")){
			System.err.println("English Letters Or positive integers!");
			System.out.println("Enter a name to continue: (only English letters or integers)");
			name = sc.nextLine();
		}
		System.out.println(name + "! Welcome to the Hangman game");
	}
}



