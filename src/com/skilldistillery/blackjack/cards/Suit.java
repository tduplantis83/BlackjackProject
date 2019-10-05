package com.skilldistillery.blackjack.cards;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	final private String name;
	
	//constructor
	Suit(String s) {
		name = s;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
