import java.util.Scanner;
import java.util.Random;

/**
 * The user has to guess a random number depending on their difficulty level.
 * They have a limited amount of attempts to guess the number correctly.<p>
 * There are three difficulties: easy, medium, and hard.
 * <ul>
 * <li>Easy: Between 1 and 10
 * <li>Medium: Between 1 and 100
 * <li>Hard: Between 1 and 1000
 * </ul>
 * 
 * @version 1.0
 * @author Thomas
 */
public class HighLow {
	
	static Scanner s = new Scanner(System.in);
	static Random r = new Random();
	
	/**
	 * The number of tries the user has to get the number right.
	 */
	static int tries = 10;
	
	/**
	 * I created this method mainly to save filesize.
	 * 
	 * @param text The text that is used in the error message.
	 */
	static void logError(String text) {
		System.err.println(text);
	}
	
	/**
	 * I created this method mainly to save filesize.
	 * 
	 * @param text The text that is used in the message.
	 */
	static void log(String text) {
		System.out.println(text);
	}

	static void easy() {
		int guess;
		int randNum = r.nextInt(11);
		if (randNum == 0) randNum = 1;

		log("Pick a number between 1 and 10");
		guess = s.nextInt();
		
		if (guess < 1 || guess > 10) {
			logError("That number is not in the range");
		}
		
		if (guess == randNum) {
			log("You win!");
		} else if (guess != randNum && tries > 1) {
			logError("Try again");
			tries--;
			easy();
		} else if (guess != randNum && tries <= 1) {
			log("You lost");
			return;
		}
	}
	
	static void medium() {
		int guess;
		int randNum = r.nextInt(101);
		if (randNum == 0) randNum = 1;

		log("Pick a number between 1 and 100");
		guess = s.nextInt();
		
		if (guess < 1 || guess > 100) {
			logError("That number is not in the range");
		}
		
		if (guess == randNum) {
			log("You win!");
		} else if (guess != randNum && tries > 1) {
			logError("Try again");
			tries--;
			medium();
		} else if (guess != randNum && tries <= 1) {
			log("You lost");
			return;
		}
	}
	
	static void hard() {
		int guess;
		int randNum = r.nextInt(1001);
		if (randNum == 0) randNum = 1;

		log("Pick a number between 1 and 1000");
		guess = s.nextInt();
		
		if (guess < 1 || guess > 1000) {
			logError("That number is not in the range");
		}
		
		if (guess == randNum) {
			log("You win!");
		} else if (guess != randNum && tries > 1) {
			logError("Try again");
			tries--;
			hard();
		} else if (guess != randNum && tries <= 1) {
			log("You lost");
			return;
		}
	}
	
	public static void main(String[] args) {
		String easy = "Easy";
		String medium = "Medium";
		String hard = "Hard";
		
		// Asks the user what they want the difficulty to be
		log("Please select a difficulty: easy, medium, or hard");
		String difficulty = s.nextLine();
		
		if (difficulty.equalsIgnoreCase(easy)) {
			easy();
		} else if (difficulty.equalsIgnoreCase(medium)) {
			medium();
		} else if (difficulty.equalsIgnoreCase(hard)) {
			hard();
		} else {
			logError("That's not a difficulty");
		}
	}
}









