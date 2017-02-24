package com.vowelcount;

//VowelCounter.java
//author: Eno Udo
//date: Nov 18, 2013
//Copyrights Reserved
//

public class VowelCounter {
	// read input from file or stdin; a e i o u separate counter for each vowel
	// count the number of vowels and nonvowels

	/**
	 * @param args
	 */
	/*
	 * interesting snippet compares whether the 'letter' char is a vowel. String
	 * vowels = "aeiou";
	 * 
	 * char letter = word.charAt(0);
	 * 
	 * return (vowels.indexOf(letter) != -1);
	 */

	private int a, e, i, o, u;
	private int nonVowel;
	private String word;
	private int wordCount;
	private int spaces;

	public VowelCounter() {
		a = 0;
		e = 0;
		i = 0;
		o = 0;
		u = 0;
		spaces = 0;
		nonVowel = 0;
		word = "";
		wordCount = 0;
	}

	// switches work on primitives and enumerated types.
	public void countVowels(String input) {
		// string.length
		word = input;
		input = input.toLowerCase();
		char[] array = input.toCharArray();
		// String vowels = "aeiou";

		for (char indx : array) {
			switch (indx) {
			case 'a':
				a++;
				break;
			case 'e':
				e++;
				break;
			case 'i':
				i++;
				break;
			case 'o':
				o++;
				break;
			case 'u':
				u++;
				break;
			case ' ':
				spaces++;
			default:
				nonVowel++;
			}

		}
		wordCount = input.equals("") ? 0 : spaces + 1;

	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getO() {
		return o;
	}

	public void setO(int o) {
		this.o = o;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getNonVowel() {
		return nonVowel;
	}

	public void setNonVowel(int nonVowel) {
		this.nonVowel = nonVowel;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getSpaces() {
		return spaces;
	}

	public void setSpaces(int spaces) {
		this.spaces = spaces;
	}

	public int getTotalVowels() {
		return (a + e + i + o + u);
	}

	@Override
	public String toString() {
		return "The sentence was: "
				+ (getWord().equals("") ? "No input detected" : getWord())
				+ "\n\n" + "Totals:\n" + "a: " + getA() + "\ne: " + getE()
				+ "\ni: " + getI() + "\no: " + getO() + "\nu: " + getU()
				+ "\ntotal vowels: " + getTotalVowels() + "\nnonvowel: "
				+ getNonVowel() + "\nspaces: " + getSpaces()
				+ "\ntotal nonvowels without counting spaces: "
				+ (nonVowel - spaces) + "\nwordcount: " + getWordCount();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VowelCounter myCounter = new VowelCounter();
		// myCounter.countVowels("Today was a good day!");
		System.out.println(myCounter.toString());

	}

}
