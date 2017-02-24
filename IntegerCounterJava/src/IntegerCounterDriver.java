import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class IntegerCounterDriver {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// will create a text file with x amount of random integers
		// will use nested for-loops to read the file and tally the number of
		// each occurence.
		// File txtFile = new File("numbers.txt");
		// reading and writing is easy but checking file existence is giving me
		// toruble
		String txtFile = "numbers.txt";
		FileWriter fw = new FileWriter(txtFile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		Random rand = new Random();
		// everything works except THIS filecheck
		// a blank file keeps being created giving a false positive.
		Boolean fileCheck = new File(txtFile).exists();
		Scanner scan = new Scanner(new File("numbers.txt"));
		// right here for some reason I cannot check whether the file exists and
		// still read from the existing file.
		// Maybe the solution is to separate these operations and their objects.
		// my options are write to append or overwrite
		// fileInputStream is currently beyond me
		if (!fileCheck) {

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
		} else
			System.out.println("file already exists");
		pw.close();
		// read
		int totalCount = 0;
		if (fileCheck) {
			scan = new Scanner(new File("numbers.txt"));
			while (scan.hasNext()) {
				for (int i = 0; i < 5; i++) {
					System.out.print(scan.nextInt() + "\t");
					totalCount++;
				}
				System.out.println();
			}
			scan.close();
		}
		System.out.println("There are " + totalCount + " entries in the file");

	}
}
