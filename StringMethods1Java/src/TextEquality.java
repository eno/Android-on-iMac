//TextEquality.java
//author: Eno Udo
//date: Nov 26, 2013
//Copyrights Reserved
//Test whether two files are equal. Print unequal lines.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextEquality {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String f1 = "";
		String f2 = "";
		Scanner scan1 = new Scanner(new File("dlscript.php"));
		Scanner scan2 = new Scanner(new File("dlscriptcopy.php"));
		while (scan1.hasNextLine()) {
			if (!scan2.hasNextLine()) {
				System.out
						.println("file2 EOF, the files are different lengths.");
			}
			f1 = scan1.nextLine();
			f2 = scan2.nextLine();
			if (!f2.equals(f1))
				System.out.println(f1 + "\n" + f2);

		}
		System.out.println("done");

	}
}
