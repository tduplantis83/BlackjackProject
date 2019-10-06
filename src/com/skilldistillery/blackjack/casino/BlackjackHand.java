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
		int countOfAces = 0;

		cards = getCards();
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();
			if(card.getValue() == 11) {
				countOfAces++;
			}
		}
		
//		if(isHardAce()) {
//			if(countOfAces > 1) {
//				
//			}
//			sum -= (countOfAces * 10);
//		}

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
//		// get all cards & determine total value
//		ArrayList<Card> cards = new ArrayList<>();
//		int sum = 0;
//
//		cards = super.getCards();
//		for (Card card : cards) {
//			sum += card.getValue();
//		}
//
//		for (Card card2 : cards) {
//			if (sum > 21 && card2.getValue() == 11) {
//				//the ace can only be used as a 1 if the 
//				//hand sum is over 21
//				return true;
//			}
//		}
//
//		return false;
//	}
//
//	public boolean isSoftAce() {
//		// get all cards & determine total value
//		ArrayList<Card> cards = new ArrayList<>();
//		int sum = 0;
//
//		cards = super.getCards();
//		for (Card card : cards) {
//			sum += card.getValue();
//		}
//
//		for (Card card2 : cards) {
//			if (sum <= 21 && card2.getValue() == 11) {
//				//the ace can be either a 1 or an 11 
//				//if the hand sum is <= 21
//				return true;
//			}
//		}
//
//		return false;
//	}

}
