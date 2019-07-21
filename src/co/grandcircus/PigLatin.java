package co.grandcircus;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PigLatin {

	public static void main(String[] args) {
		// initial setup
		Scanner scan = new Scanner(System.in);
		char cont = 'y';
		String entry;
		String[] stringArr;

		// user prompt
		System.out.println("It's Pig Latin time!");
		while (cont == 'y' || cont == 'Y') {
			System.out.println("Enter a line to be translated: ");
			entry = scan.nextLine();

			// displaying results
			stringArr = entry.split(" ");
			input(stringArr);
			System.out.println();
			System.out.println("Translate another line? (y/n)");
			cont = scan.nextLine().charAt(0);
		}
		scan.close();
	}

	// takes the user input and runs each word individually
	private static String[] input(String[] stringArr) {
		for (String word : stringArr) {
			System.out.print(translator(word));
		}
		return stringArr;
	}

	// translates a single word each time it's called
	private static String translator(String stringArr) {
		StringBuffer word = new StringBuffer(stringArr);
		String newWord;
		// checks for non-letters
		if (Pattern.matches("[a-zA-Z]+", word)) {
			for (int i = 0; i < word.length(); i++) {
				switch (word.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				// translates the word if a vowel is found
					word.append(word, 0, i).delete(0, i);
					if (i == 0) {
						newWord = word.toString() + "way ";
						return newWord;
					} else
						newWord = word.toString() + "ay ";
					return newWord;
				// loops again if a consonant is found
				default:
				}
			}
		} else {
			return stringArr;
		}
		return stringArr;
	}
}
