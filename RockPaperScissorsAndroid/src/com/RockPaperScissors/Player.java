package com.RockPaperScissors;
public class Player {
	// The solution is way too complicated for something like this. It's such a
	// simple comparison that is gone out of control.
	// This proble is due to lack of planning
	// ---
	// Scratch that. I survived.

	// the idea is to store procedures in methods.
	// as well as return calculations to store in instanced variables.
	int wins, losses, ties;
	int rocks;
	int papers;
	int scissors;
	String name;

	public Player(String name) {
		this.name = name;
		if (name.toLowerCase().equals("ai"))
			this.name = "Computer";
		// ai player named ComputerHostname;
		wins = losses = ties = rocks = papers = scissors = 0;

	}

	public int getWins() {
		return wins;
	}

	public void addWins(int i) {
		wins += i;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void addLosses(int i) {
		losses += i;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void addTies(int i) {
		ties += i;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String pick(String in) {

		if (in.toLowerCase().charAt(0) == 'r')
			return "rock";
		else if (in.toLowerCase().charAt(0) == 'p')
			return "paper";
		else if (in.toLowerCase().charAt(0) == 's')
			return "scissors";
		else
			return "wrong";

	}

}
