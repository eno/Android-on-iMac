import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class try2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		int totalCount = 0;
		String txtFile = "numbers.txt";
		FileWriter fw = new FileWriter(txtFile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		Boolean fileCheck = new File(txtFile).exists();
		Scanner scan = new Scanner(new File("numbers.txt"));
		// this version checks if the file exists before trying to write it.
		// doesnt work either. I guess that you cannot do this in eclipse

		if (fileCheck && scan.hasNext()) {
			scan = new Scanner(new File("numbers.txt"));
			while (scan.hasNext()) {
				for (int i = 0; i < 5; i++) {
					System.out.print(scan.nextInt() + "\t");
					totalCount++;
				}
				System.out.println();
			}
			scan.close();
			System.out.println("There are " + totalCount
					+ " entries in the file");

		} else {
			Random rand = new Random();
			// random numbers 101 -200
			// System.out.println(rand.nextInt(100) + 101);
			// command+3 to get to quick access
			// cmnd +opt+z to surround
			// ctrl + shf+ r to find a file in projects
			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < 5; i++) {
					pw.print((rand.nextInt(100) + 101) + "\t");
				}
				pw.println();
			}

			System.out.println(txtFile + " created");

		}
		pw.close();
	}
}
