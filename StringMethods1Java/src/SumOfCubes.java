import java.util.Scanner;

public class SumOfCubes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("enter value x.");
		double x = scan.nextDouble();
		System.out.print("enter value y.");
		double y = scan.nextDouble();

		System.out.println("x^3: " + (x * x * x) + "\ny^3: " + (y * y * y)
				+ "\nx^3+y^3: " + ((x * x * x) + (y * y * y)));

	}
}
