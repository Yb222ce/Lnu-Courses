public class Level extends Hangman {
	
	public static int count = 0;

	public boolean playGameHard() {
		this.surviving = 3;

		randomWord();
		char alphaGuess = ' ';

		System.out.println("\n lets start \n( to stop playing press'0' \nYou have " + surviving
				+ " guesses to find the unknown word");

		while (this.surviving > 0) {
			System.out.println("Type your guess between: " + hiddenWord.length() + " characters" + "\n" + hiddenWord);
			alphaGuess = scan.next().charAt(0);
			boolean correct = false;

			for (int i = 0; i < this.unknownWord.length(); i++) {
				if (alphaGuess == this.unknownWord.charAt(i)) {
					correct = true;

				} else if (alphaGuess == this.unknownWord.charAt(i) || alphaGuess == '*' ) {
					System.out.println("You stopped guessing.");
					return askForRestart();
				}

			}

			for (int i = 0; i < this.hiddenWord.length(); i++) {
				if (alphaGuess == hiddenWord.charAt(i))
					entered = true;

			}
			if (entered) {
				System.out.println("Already entered\n");
				entered = false;
			}

			if (correct) {
				int position = this.unknownWord.indexOf(alphaGuess);
				while (position >= 0) {

					replaceChar(alphaGuess, position);
					position = this.unknownWord.indexOf(alphaGuess, position + 1);
				}

				System.out.println("\nCorrect Guesses!");
			}

			else if (!correct) {
				System.err
				.println("Sorry, the letter is not in the unknown word." + "\nWrong character! Try again!\"  ");
				surviving--;

				if (surviving == 3) {
					System.out.println();
					System.out.println("*************"
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |");
				} else if (surviving == 2) {
					System.out.println();
					System.out.println("*************"
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          "
							+"\n||         "
							+"\n||"
							+"\n||____"
							+"\n|_____]");
				} else if (surviving == 0) {
					System.out.println();
					System.out.println("************"
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||"
							+"\n||____"
							+"\n|_____]");
					System.out.println("\nThe man is hanged\n");
				}
			}

			System.out.println("You have " + surviving + " tries left\n");

			if (this.surviving == 0) {
				System.out.println("Out of tries!");
				System.out.println("The letter " + "\"" + unknownWord + "\"" + " was the unknown word");

			} else if (!this.hiddenWord.contains("-")) {
				System.out.println(unknownWord + "! \nYou won!\nYou saved a man!!");
				count++;
				break;

			}

		}
		this.surviving = 3;
		this.list = true;
		return askForRestart();
	}

	//#################################################
	
	
	public boolean playGameMedium() {
		this.surviving = 5;

		randomWord();
		char alphaGuess = ' ';

		System.out.println("\n lets start \n( to stop playing press'0' \nYou have " + surviving
				+ " guesses to find the unknown word");

		while (this.surviving > 0) {
			System.out.println("Type your guess between: " + hiddenWord.length() + " characters" + "\n" + hiddenWord);
			alphaGuess = scan.next().charAt(0);
			boolean correct = false;

			for (int i = 0; i < this.unknownWord.length(); i++) {
				if (alphaGuess == this.unknownWord.charAt(i)) {
					correct = true;

				} else if (alphaGuess == this.unknownWord.charAt(i) || alphaGuess == '*' ) {
					System.out.println("You stopped guessing.");
					return askForRestart();
				}

			}

			for (int i = 0; i < this.hiddenWord.length(); i++) {
				if (alphaGuess == hiddenWord.charAt(i))
					entered = true;

			}
			if (entered) {
				System.out.println("Already entered\n");
				entered = false;
			}

			if (correct) {
				int position = this.unknownWord.indexOf(alphaGuess);
				while (position >= 0) {

					replaceChar(alphaGuess, position);
					position = this.unknownWord.indexOf(alphaGuess, position + 1);
				}

				System.out.println("\nCorrect Guesses!");
			}

			else if (!correct) {
				System.err
				.println("Sorry, the letter is not in the unknown word." + "\nWrong character! Try again!\"  ");
				surviving--;

				if (surviving == 3) {
					System.out.println();
					System.out.println("*************"
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |");
				} else if (surviving == 2) {
					System.out.println();
					System.out.println("*************"
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          "
							+"\n||         "
							+"\n||"
							+"\n||____"
							+"\n|_____]");
				





				} else if (surviving == 0) {
					System.out.println();
					System.out.println("************"
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||"
							+"\n||____"
							+"\n|_____]");

					System.out.println("\nThe man is hanged\n");

				}

			}

			System.out.println("You have " + surviving + " tries left\n");

			if (this.surviving == 0) {
				System.out.println("Out of tries!");
				System.out.println("The letter " + "\"" + unknownWord + "\"" + " was the unknown word");

			} else if (!this.hiddenWord.contains("-")) {
				System.out.println(unknownWord + "! \nYou won!\nYou saved a man!!");
				count++;
				break;

			}

		}
		this.surviving = 5;
		this.list = true;
		return askForRestart();
	}
	
	
	//#################################################
	
	public boolean playGameEasy() {

		randomWord();
		char charGuess = ' ';

		System.out.println("\nAlright! lets begin\n(Press '*' to stop guessing the word at any stage \nYou have " + surviving
				+ " guesses to find the unknown word");

		while (this.surviving > 0) {

			System.out.println("Type your guess between: " + hiddenWord.length() + " characters" + "\n" + hiddenWord);
			charGuess = scan.next().charAt(0);
			boolean correct = false;

			for (int i = 0; i < this.unknownWord.length(); i++) {
				if (charGuess == this.unknownWord.charAt(i)) {
					correct = true;

				} else if (charGuess == this.unknownWord.charAt(i) || charGuess == '*') {
					System.out.println("You stopped guessing.");
					return askForRestart();
//					this.menu = true;

				}

			}

			for (int i = 0; i < this.hiddenWord.length(); i++) {
				if (charGuess == hiddenWord.charAt(i))
					entered = true;

			}
			if (entered) {
				System.out.println("Already entered\n");
				entered = false;
			}

			if (correct) {
				int position = this.unknownWord.indexOf(charGuess);
				while (position >= 0) {

					replaceChar(charGuess, position);
					position = this.unknownWord.indexOf(charGuess, position + 1);

				}

				System.out.println("\nCorrect Guesses!");
			}

			else if (!correct) {
				// countCharacters++;
				System.err
						.println("Sorry, the letter is not in the missingword." + "\nWrong character! Try again!\"  ");
				surviving--;

				if (surviving == 5) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |");
				} else if (surviving == 3) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          "
							+"\n||         "
							+"\n||"
							+"\n||____"
							+"\n|_____]");
				





				} else if (surviving == 0) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||"
							+"\n||____"
							+"\n|_____]");
					System.out.println("\nThe man is hanged\n");


				}

			}

			System.out.println("You have " + surviving + " tries left\n");

			if (this.surviving == 0) {
				System.out.println("Out of tries!");
				System.out.println("The letter " + "\"" + unknownWord + "\"" + " was the unknown word");

			} else if (!this.hiddenWord.contains("-")) {
				System.out.println(unknownWord + "!!!! \nYou won!\nYou saved a man!!");
				count++;
				break;

			}

		}
		this.surviving = 7;
		this.list = true;
		return askForRestart();
	}
}

