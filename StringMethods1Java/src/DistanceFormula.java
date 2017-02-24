import java.util.Scanner;

public class DistanceFormula {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println("Enter two sets of coordinates to calculate the distance between the two points");
		Scanner scan = new Scanner(System.in);
		System.out.print("x1: ");
		double x1 = scan.nextDouble();
		System.out.print("y1: ");
		double y1 = scan.nextDouble();
		System.out.print("x2: ");
		double x2 = scan.nextDouble();
		System.out.print("y2: ");
		double y2 = scan.nextDouble();
		System.out.println("the points are (" + x1 + "," + y1 + ") and (" + x2
				+ "," + y2 + ")");
		double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1)
				* (y2 - y1));
		System.out.println("and the distance between these two points is "
				+ distance);
	}

}
