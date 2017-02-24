import java.util.Scanner;

public class Sphere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the radius of your sphere");
		Scanner scan = new Scanner(System.in);
		double r = scan.nextDouble();
		// watch that integer division |
		double vol = ((double) 4 / 3) * (Math.PI) * (r * r * r);
		double surface = 4 * Math.PI * (r * r);
		// System.out.println("volume: " + vol + "\nsurface: " + surface);
		System.out.printf("vol: %.4f\nsurface: %.4f", vol, surface);

	}

}
