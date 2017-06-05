package com.thomson;

import java.util.Scanner;

public class Translator {

	public static void main(String[] args) {
		System.out.println("What is your word?");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();

		System.out.println(revers(word));
	}

	public static String revers(String engWord) {
		System.out.print("Your Martian word is: ");

		String backwardsWord = new StringBuilder(engWord).reverse().toString().toLowerCase();
		String marsWord = backwardsWord.toUpperCase().substring(0, 1) + backwardsWord.substring(1, engWord.length());
		return marsWord;
	}
}
