import java.util.Random;

public class telephoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("phone number generator");
		Random rand = new Random();
		int[] phone = new int[10];
		for (int i = 0; i < 3; i++) {
			phone[i] = rand.nextInt(8);
		}
		phone[3] = rand.nextInt(8);
		phone[4] = rand.nextInt(5);
		phone[5] = rand.nextInt(3);
		for (int i = 6; i < 9; i++) {
			phone[i] = rand.nextInt(10);
		}
		for (int i = 0; i < phone.length; i++) {
			System.out.print(phone[i]);
			if (i == 2 || i == 5)
				System.out.print("-");

		}

	}

}
