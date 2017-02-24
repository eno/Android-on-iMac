import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.RockPaperScissors.Game;

public class StringTest1 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Game game = new Game();
		String myString = "  Hello   ";
		System.out.println(myString.charAt(2));
		System.out.println(myString.trim().charAt(2));
		System.out.printf("%s, %s|\n", myString, myString);
		File toFile = new File("toFile.txt");

		// create this as a packaged static method
		FileWriter fw = new FileWriter(toFile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(myString);
		System.out.println("done printing");
		pw.close();
		// System.out.println(myString);

	}

}
