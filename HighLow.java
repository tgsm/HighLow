import java.util.Scanner;
import java.util.Random;

/**
 * The user has to guess a random number depending on their difficulty level. They have a limited amount of attempts to guess the number correctly.
 * <p>
 * There are three difficulties: easy, medium, and hard.
 * <ul>
 * <li>Easy: Guess between 1 and 10
 * <li>Medium: Guess between 1 and 100
 * <li>Hard: Guess between 1 and 1000
 * </ul>
 * 
 * @version 1.0
 * @author Thomas
 */
public class HighLow {
	Scanner s = new Scanner(System.in);
	Random r = new Random();

	// The number of tries the user has to get the number right.
	int tries = 10;

	HighLow() {
		while (true) {
			// Ask the user what they want the difficulty to be
			System.out.println("Please select a difficulty: easy, medium, or hard");
			String difficulty = s.nextLine();

			if (difficulty.equalsIgnoreCase("easy")) {
				easy();
				break;
			} else if (difficulty.equalsIgnoreCase("medium")) {
				medium();
				break;
			} else if (difficulty.equalsIgnoreCase("hard")) {
				hard();
				break;
			} else {
				System.err.println("That's not a difficulty");
			}
		}
	}

	void easy() {
		int guess;
		int randNum = r.nextInt(11);
		if (randNum == 0) randNum = 1;

		System.out.println("Pick a number between 1 and 10");
		guess = s.nextInt();

		if (guess < 1 || guess > 10) {
			System.err.println("That number is not in the range");
		}

		if (guess == randNum) {
			System.out.println("You win!");
		} else if (guess != randNum && tries > 1) {
			tries--;
			System.err.println("Try again, you have " + tries + " tries left!");
			easy();
		} else if (guess != randNum && tries <= 1) {
			System.err.println("You lost");
			return;
		}
	}

	void medium() {
		int guess;
		int randNum = r.nextInt(101);
		if (randNum == 0) randNum = 1;

		System.out.println("Pick a number between 1 and 100");
		guess = s.nextInt();

		if (guess < 1 || guess > 100) {
			System.err.println("That number is not in the range");
		}

		if (guess == randNum) {
			System.out.println("You win!");
		} else if (guess != randNum && tries > 1) {
			tries--;
			System.err.println("Try again, you have " + tries + " tries left!");
			medium();
		} else if (guess != randNum && tries <= 1) {
			System.out.println("You lost");
			return;
		}
	}

	void hard() {
		int guess;
		int randNum = r.nextInt(1001);
		if (randNum == 0) randNum = 1;

		System.out.println("Pick a number between 1 and 1000");
		guess = s.nextInt();

		if (guess < 1 || guess > 1000) {
			System.err.println("That number is not in the range");
		}

		if (guess == randNum) {
			System.out.println("You win!");
		} else if (guess != randNum && tries > 1) {
			tries--;
			System.err.println("Try again, you have " + tries + " tries left!");
			hard();
		} else if (guess != randNum && tries <= 1) {
			System.err.println("You lost");
			return;
		}
	}

	public static void main(String[] args) {
		new HighLow();
	}
}