//StarPattern.java
//author: Eno Udo
//date: Nov 15, 2013
//Copyrights Reserved
//todo: android version can use a spinner to select which pattern to display

public class StarPattern {

	/**
	 * @param args
	 */

	public static void rightDecline() {
		/*
		 * int max = 10; int stars = max; for (int i = 0; i < 10; i++) { while
		 * (stars >= 1) { System.out.print("*"); stars--; } max -= 1; stars =
		 * max; System.out.println(); }
		 */

		// OPTIMIZED rewritten code.
		for (int i = 10; i > 0; i--) {
			for (int stars = i; stars >= 1; stars--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void leftDecline() {
		// UNOPTIMIZED version that i used while writing the code.
		int max = 0;
		int stars = max;
		for (int i = 0; i < 10; i++) {
			for (int j = (9 - max); j > 0; j--)
				System.out.print(" ");
			while (stars <= max) {
				System.out.print("*");
				stars++;
			}
			max += 1;
			stars = 0;
			System.out.println();
		}
	}

	public static void leftDeclineOptimized() {

		for (int i = 0; i < 10; i++) {
			for (int j = 9; j >= i; j--)
				System.out.print(" ");
			for (int stars = 0; stars <= i; stars++)
				System.out.print("*");
			System.out.println();

		}
	}

	public static void innerLeftDecline() {
		// int max = 10;
		// int stars = max;
		for (int i = 10; i > 0; i--) {
			for (int j = (10 - i); j > 0; j--)
				System.out.print(" ");
			for (int stars = i; stars >= 1; stars--) {
				System.out.print("*");
			}
			// max -= 1;
			// stars = max;
			System.out.println();
		}
	}

	public static void diamond2() {
		// optimized. I don't even know how I did it.
		for (int i = 1; i < 10; i += 2) {
			for (int j = 9; j >= i; j -= 2)
				System.out.print(" ");
			for (int stars = 1; stars <= i; stars++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = 10; i > 1; i -= 2) {
			for (int j = 20 - i; j >= i; j -= 4)
				System.out.print(" ");
			for (int stars = 1; stars <= i - 1; stars++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void diamond() {
		// rightdecline " ", leftdecline '*'.
		// unoptimized but a little bit easier to write
		int max = 0;
		int stars = max;
		for (int i = 0; i < 5; i++) {// main row loop
			for (int j = (9 - max); j > 0; j = j - 2)
				// spaces loop
				System.out.print(" ");
			while (stars <= 0) {// stars loop
				System.out.print("*");
				stars++;
			}// end stars loop
			max += 2;
			stars = 0;
			System.out.println();
		}
		max -= 2;
		for (int i = 0; i < 5; i++) {// second row loop
			// second half
			for (int j = (9 - max); j > 0; j = j - 2)
				// spaces loop
				System.out.print(" ");
			while (stars <= max) {// stars loop
				System.out.print("*");
				stars++;
			}// end stars loop
			max -= 2;
			stars = 0;
			System.out.println();
		}// end second row loop

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// leftDecline();
		 rightDecline();
		// innerLeftDecline();
		//diamond2();

	}

}
