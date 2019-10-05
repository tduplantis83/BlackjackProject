package com.skilldistillery.blackjack.cards;

import java.util.*;

public class Deck {
	List<Card> deck = new ArrayList<>(52);

	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (Suit s : suits) {
			for (Rank r : ranks) {
				deck.add(new Card(s, r));
			}
		}
		
		//shuffles cards only once per game
		shuffle();

	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		//return a random card from the (already shuffled) deck
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

}
