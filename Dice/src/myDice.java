//myDice.java
//author: Eno Udo
//date: Nov 11, 2013
//Copyrights Reserved
// a die class with variable number of sides(face value) and variable number of rolls.

public class myDice {
	private int max = 6; // max facevalue
	private int faceValue; // current value showing on the die
	private int numRolls;

	public myDice(int sides, int rolls) {
		max = sides;
		numRolls = rolls;
	}

	// compute a new value for this die and return the result
	// method rolls the die f times
	public int[] roll() {
		int f = numRolls;
		int[] rolls = new int[f];
		for (int i = 0; i < f; i++) {
			faceValue = (int) (Math.random() * max) + 1;
			rolls[i] = faceValue;
		}
		return rolls;

	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	public int getNumRolls() {
		return numRolls;
	}

	public void setNumRolls(int numRolls) {
		this.numRolls = numRolls;
	}

	@Override
	public String toString() {
		return "myDice [max=" + max + ", faceValue=" + faceValue
				+ ", numRolls=" + numRolls + "]";
	}

	// for each value in my array i want to display it to the user.
	// a better way would be to call singular roll() x times where is the number
	// of rolls.
	public static void main(String[] args) {
		myDice d1 = new myDice(20, 5);
		int[] myRoll = d1.roll();
		int rNum = 1;
		for (int i : myRoll) {

			System.out.println("roll " + (rNum) + ": " + i);
			rNum++;
		}

	}

}
