package com.skilldistillery.blackjack.casino;

import com.skilldistillery.blackjack.cards.*;

import java.util.*;

public class Player {
	private String type;
	private String name;
	private int cardTotal;
	private BlackjackHand b = new BlackjackHand();

	public Player(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public char hitOrStay(Scanner s) {
		char c;
		if (type.equalsIgnoreCase("Human")) {
			System.out.println("Your hand is worth " + b.getHandValue());

			//check for hard/soft ace
			if(b.isHardAce()) {
				System.out.println("Hard Ace - your Ace only be worth 1.");
			}
			if(b.isSoftAce()) {
				System.out.println("Soft Ace - your Ace be worth 11");
			}
			System.out.print("Hit or Stay (H/S)?");
			c = s.next().toUpperCase().charAt(0);
		}
		// dealer
		else {
			if (this.b.getHandValue() == 17 && b.isSoftAce()) {
				System.out.println("Dealer hits on soft 17");
				c = 'H';
			}
			else if (this.b.getHandValue() < 17) {
				c = 'H';
			}
			else {
				c = 'S';
			}
		}

		return c;

	};

	public String getName() {
		return this.name;
	}

	public List<Card> getHand() {
		return this.b.getCards();
	}

	public void addToHand(Card c) {
		this.b.addCard(c);
	}

	public int getHandValue() {
		return this.b.getHandValue();
	}

	public boolean bust() {
		return this.b.isBust();
	}

	public boolean blackjack() {
		return this.b.isBlackjack();
	}

	public int dealerShowingValue() {
		ArrayList<Card> c = new ArrayList<>();
		int sum = 0;
		c = this.b.getCards();

		for (int i = 1; i < c.size(); i++) {
			if(c.get(i).getRankName().equalsIgnoreCase("Ace")) {
				System.out.println("**CAUTION: Dealer has an Ace**");
				System.out.println("**Displayed vs Actual hand value will vary**");
			}
			sum += c.get(i).getValue();
		}

		return sum;
	}

}
