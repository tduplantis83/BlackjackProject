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
		if(type.equalsIgnoreCase("Human")) {
			System.out.println("Your hand is worth " + b.getHandValue());
			System.out.print("Hit or Stay (H/S)?");
			c = s.next().toUpperCase().charAt(0);
		}
		//dealer
		else {
			if(this.b.getHandValue() < 17) {
				c = 'H';
			}
			else {
				c = 'S';
			}
		}
		System.out.println();
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
		ArrayList <Card> c = new ArrayList<>();
		int sum = 0;
		c = this.b.getCards();
		
		for(int i = 1; i < c.size(); i++) {
			sum += c.get(i).getValue();
		}
		
		return sum;
	}

}
