import java.util.Random;
import java.util.Scanner;

public class username {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your first name");
		String fName = scan.next();
		System.out.print("Enter your last name");
		String lName = scan.next();
		Random rand = new Random();

		String uName = fName.charAt(0) + lName.substring(0, 5)
				+ (rand.nextInt(90) + 10);
		System.out.println("your username at this site is " + uName);

	}

}
