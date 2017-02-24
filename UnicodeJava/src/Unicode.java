
//Unicode.java
//author: Eno Udo
//date: Nov 13, 2013
//Copyrights Reserved
//Unicode test to print out the unicode subset of the ASCII characters.

public class Unicode {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * char uni = ' '; int digi = 32; System.out.println("this :" + (char)
		 * digi + ": that");
		 * 
		 * System.out.println("this :" + Integer.toString(uni) + ": that");
		 * System.out.println(Character.forDigit(32, 1));
		 */
		// 32 to 126 are unicode subset of ascii
		// 5 per line, separated by tabs
		int i = 32;
		while (i < 127) {
			for (int j = 0; j < 5; j++) {

				System.out.print((char) i + "\t");
				i++;
				Thread.sleep(100);
			}
			System.out.println();

		}
	}

}
