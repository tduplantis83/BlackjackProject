package com.skilldistillery.blackjack.casino;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	public ArrayList<Card> getCards() {
		return super.getCards();
	}

	public void addCard(Card c) {
		super.addCard(c);
	}

	@Override
	public int getHandValue() {
		ArrayList<Card> cards = new ArrayList<>();

		cards = getCards();
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();
		}

		return sum;

	}

	public boolean isBlackjack() {
		if (this.getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

//	public boolean isHardAce() {
//		
//		return false;
//	}
//
//	public boolean isSoftAce() {
//		
//		return false;
//	}

}
