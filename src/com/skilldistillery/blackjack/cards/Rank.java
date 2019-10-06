package com.skilldistillery.blackjack.cards;

public enum Rank {
	TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"), JACK(10, "Jack"), QUEEN(10,"Queen"), KING(10, "King"),
	ACE(11, 1, "Ace");

	final private int rank;
	final private String name;
	private int softValue;

	Rank(int r, String n) {
		rank = r;
		name = n;
	}
	
	Rank(int r, int sV, String n) {
		rank = r;
		softValue = 1;
		name = n;
	}

	public int getRank() {
		return rank;
	}
	
	public String getRankName() {
		return name;
	}
	
	public int getSoftRank() {
		return softValue;
	}

}
