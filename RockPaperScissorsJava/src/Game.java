import java.util.Random;
import java.util.Scanner;

public class Game {
	// todo add some thread sleeps to let the game have some drama and suspense.
	Scanner scan;
	String gameOver, gameOver1;
	Random rand;
	int aiPick;
	String p1pick = "", p2pick = "";

	Player P1;
	Player P2;

	public Game() {
		scan = new Scanner(System.in);
		gameOver = gameOver1 = "";
		rand = new Random();
		// initialize player names
		Player P1 = new Player();
		Player P2 = new Player();

	}

	public void play() {
		System.out.println("Welcome to Rock /Paper/Scissors");
		// System.out.println("you may enter 'quit' to end the game at any time");

		System.out.print("What's your name Player 1?");
		// Player P1 = new Player(scan.next());
		System.out.println("Enter 'AI' for a computerized player");
		System.out.print("What's your name Player 2?");
		// Player P2 = new Player(scan.next());
		do {
			System.out.println("Welcome to Rock/Paper/Scissor");
			System.out.println("state your symbol sybols to begin");
			System.out.print(P1.getName() + "'s turn: ");
			gameOver = scan.next();

			p1pick = P2.pick(gameOver);
			System.out.print(P2.getName() + "'s turn: ");
			if (P2.getName().toLowerCase().equals("computer")) {
				aiPick = rand.nextInt(3);

				switch (aiPick) {
				case 0:
					p2pick = "rock";
					break;
				case 1:
					p2pick = "paper";
					break;
				case 2:
					p2pick = "scissors";
					break;
				default:
				}
				System.out.println(p2pick);
			} else {
				gameOver1 = scan.next();

				p2pick = P2.pick(gameOver1);
			}
			System.out.print("The winner is ");
			if (eval(p1pick, p2pick).equals("tie")) {
				// tie counted even if input is bad.
				P1.addTies(1);
				System.out.println("... wait it's a tie");
				P2.addTies(1);
			} else if (eval(p1pick, p2pick).equals("p1")) {
				P1.addWins(1);
				System.out.println(P1.getName());
				System.out.println(p1pick + " beats " + p2pick);
				P2.addLosses(1);
			} else if (eval(p1pick, p2pick).equals("p2")) {
				P2.addWins(1);
				System.out.println(P2.getName());
				System.out.println(p2pick + " beats " + p1pick);
				P1.addLosses(1);
			} else
				System.out.println("the options are 'rock, paper , scissors'");
			System.out.println();

			// thread sleeps between rounds.
			System.out.println(P1.getName() + "'s wins: " + P1.getWins());
			System.out.println(P2.getName() + "'s wins: " + P2.getWins());
			System.out.println("ties: " + P1.getTies());
			System.out
					.println("you may enter 'quit' to end the game at any time");
			System.out.println();
			System.out.println(gameOver);
			System.out.println();
		} while (!gameOver.equals("quit") && !gameOver1.equals("quit"));
		System.out.println();
		System.out.println("Thanks for playing");
	}

	public String eval(String p1, String p2) {
		String returns = "";
		if (p1.equals(p2))
			returns = "tie";
		else if (p1.equals("rock") && p2.equals("paper"))
			returns = "p2";
		else if (p1.equals("rock") && p2.equals("scissors"))
			returns = "p1";
		else if (p1.equals("paper") && p2.equals("scissors"))
			returns = "p2";
		else if (p1.equals("paper") && p2.equals("rock"))
			returns = "p1";
		else if (p1.equals("scissors") && p2.equals("paper"))
			returns = "p1";
		else if (p1.equals("scissors") && p2.equals("rock")) {
			returns = "p2";
		}

		else
			returns = "Bad input, try again";
		return returns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game RPS = new Game();
		// Player p1 = new Player();
		// Player p2 = new Player();

		RPS.play();
		// p1.pick(scan.next());
		// p2.pick();
		// RPS.eval();
		// RPS.displayScore();
		// loops

	}

}
