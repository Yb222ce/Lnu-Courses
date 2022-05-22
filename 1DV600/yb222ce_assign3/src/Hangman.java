import java.util.*;

public class Hangman {

	public int surviving = 7;
	public String unknownWord = "";
	public String hiddenWord = "";
	Scanner scan = new Scanner(System.in);
	public boolean list = true;

	public boolean validInput;

	public boolean entered;
	public String name = "";

	public boolean askForRestart() {
		int number;

		boolean restart;
		System.out.println(
				"\n\nDo you want to play again?\nPress 1: restarts the game.\nPress any positive integer to quit the game.");
		do {
			number = scan.nextInt();

		} while (restart = !validInteger(number));
		if (number > 1)

			restart = true;
		if (restart) {
			System.out.println("Thank you and Goodbye ");
			System.out.println("You revealed " + Level.count + " unknown words");

			System.exit(0);
		}

		this.list = false;

		return !restart;

	}

	public boolean validInteger(int number) {
		while (number < 0) {
			System.out.println("Enter positive integer");
			return false;
		}
		if (number == 1) {
			unknownWord = "";
			hiddenWord = "";
			return true;

		}

		return true;
	}

	public void replaceChar(char str, int pos) {
		StringBuilder sb = new StringBuilder(this.hiddenWord);
		sb.setCharAt(pos, str);
		this.hiddenWord = sb.toString();
	}

	public void endtheGame() {

		System.out.println("You quit the Game\nGoodbye!");
		System.exit(0);
	}

	public void randomWord() {
		System.out.println("\nChoose one of the following numbers\n\n3: Name of the countries\n4: Car brands \n5: Quit");
		do {
			int category = scan.nextInt();

			switch (category) {
				case 3:
					String[] nameOfTheCountries = { "argentina", "yemen", "georgia", "germany", "sweden", "russia",
							"tajikistan","turkey","lebanon","canada"};
					Random rnd = new Random();
					int index = rnd.nextInt(nameOfTheCountries.length);
					this.unknownWord = nameOfTheCountries[index];

					for (int i = 0; i < this.unknownWord.length(); i++) {
						this.hiddenWord += "-";
					}
					validInput = false;
					break;
				case 4:
					String[] carBrands = { "ferrari", "mercedes", "Nissan", "hyundai", "ballot", "ford","audi",
							"toyota","volvo","bugatti"+"mitsubishi"};
					Random rand1 = new Random();
					int index1 = rand1.nextInt(carBrands.length);
					this.unknownWord = carBrands[index1];

					for (int i = 0; i < this.unknownWord.length(); i++) {
						this.hiddenWord += "-";
					}
					validInput = false;
					break;
				case 5:
					endtheGame();
					break;
				default:
					System.out.println(
							"Wrong entery.\nCould you proivde again!\nChoose one of the following options\n\n3: Name of the countries\n4: Car brands \n5: Quit\"");
					validInput = true;

			}

		} while (validInput);

	}

	public boolean play() {
		return this.list;
	}

	public int gamelist() {
		System.out.println("To contintue choose a number:\n--------------\n" + " 1:--> Play Easy\n"
				+" 2:--> Play Medium\n"+" 3:--> Play Hard\n" + " 4:--> Quit \n" + "--------------");
		System.out.print("choose a number: ");
		return scan.nextInt();

	}

	public static Object provideValidName(String string) {
		return true;
	}

	public static Object validInputToEnd() {
		return false;
	}

	public Object enterValidName(String string) {
		return true;
	}
}



