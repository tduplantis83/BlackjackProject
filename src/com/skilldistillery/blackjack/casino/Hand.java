package com.skilldistillery.blackjack.casino;
import com.skilldistillery.blackjack.cards.Card;

import java.util.*;


public abstract class Hand {
	protected ArrayList <Card> cards = new ArrayList<>();
	
	public Hand() {
		
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public ArrayList <Card> getCards() {
		return cards;
	}
	
	public void clear() {
		cards = null;
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nHand of Cards: ");
		builder.append(cards);
		return builder.toString();
	}
	
	
}
