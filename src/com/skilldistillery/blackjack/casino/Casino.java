package com.skilldistillery.blackjack.casino;

import java.util.*;

import com.skilldistillery.blackjack.cards.*;

public class Casino {

	private static Scanner s = new Scanner(System.in);
	private static Player p1;
	private static String playerName;
	private static Player dealer;
	public static Deck deck;

	public Casino() {

	}

	public static void main(String[] args) {
		Casino c = new Casino();

		c.launch();

	}

	private void launch() {
		char again = 'N';
		mainMenu();
		do {
			// show welcome menu & get Human player's name
			p1 = new Player("Human", playerName);
			dealer = new Player("Computer", "Dealer");
			deck = new Deck();
			System.out.println("***********LET'S PLAY***********");
			playAGame();

			do {
				System.out.println("Play Again? Y/N");
				again = s.next().toUpperCase().charAt(0);
				s.nextLine();
				if (again != 'Y' && again != 'N') {
					System.err.println("\nERROR - Please enter Y/N only. Try again.\n");
				}
			} while (again != 'Y' && again != 'N');
		} while (again == 'Y');

		System.out.println("Thanks for playing. See you next time!");

	}

	private void mainMenu() {

		System.out.println("********* Welcome to the Skill Distillery Casino *********");
		System.out.println("\tThe Blackjack Tables are right this way...");
		System.out.println();
		System.out.print("\tPlease enter your name: ");

		playerName = s.nextLine();
	}

	private void playAGame() {
		boolean p1Blackjack;
		boolean p1Bust;
		boolean dealerBlackjack;
		boolean dealerBust;

		// deal initial two cards to each player
		for (int i = 0; i < 2; i++) {
			// player 1
			dealCards(p1);

			// dealer
			dealCards(dealer);
		}

		p1Blackjack = checkBlackjack(p1);
		p1Bust = checkBust(p1);
		dealerBlackjack = checkBlackjack(dealer);
		dealerBust = checkBust(dealer);

		char choice;

		// if no one busted or won yet, continue...
		if (!p1Blackjack && !p1Bust && !dealerBlackjack && !dealerBust) {

			// hit or stand player 1
			choice = 'H';

			while (choice == 'H') {
				choice = userChoice(p1.hitOrStay(s));
				if (choice == 'H') {
					dealCards(p1);
					p1Blackjack = checkBlackjack(p1);
					p1Bust = checkBust(p1);
					if (p1Blackjack) {
						break;
					} else if (p1Bust) {
						break;
					}
				} else if (choice == 'S') {
					break;
				} else {
					System.err.println("\nERROR - Invalid Input. Please choose H or S.\n");
					choice = 'H';
				}
			}
		}

		// if no one busted or won yet, continue...
		if (!p1Blackjack && !p1Bust && !dealerBlackjack && !dealerBust) {

			// hit or stand dealer
			choice = 'H';

			while (choice == 'H') {
				choice = userChoice(dealer.hitOrStay(s));
				if (choice == 'H') {
					System.out.println("Dealer chose to hit.");
					dealCards(dealer);
					dealerBlackjack = checkBlackjack(dealer);
					dealerBust = checkBust(dealer);
					if (dealerBlackjack) {
						break;
					} else if (dealerBust) {
						break;
					}
				} else {
					System.out.println("Dealer chose to stay.\n");
				}
			}
		}

		// if no one busted or won yet, continue...
		if (!p1Blackjack && !p1Bust && !dealerBlackjack && !dealerBust) {

			// no busts && no blackjacks yet
			// push
			if (p1.getHandValue() == dealer.getHandValue()) {
				System.out.println("Push - It's a tie " + p1.getName());
				displayFinalHand(p1);
			}
			// highest card
			else if (p1.getHandValue() > dealer.getHandValue()) {
				System.out.println("Player 1 wins! Great job " + p1.getName() + "!");
				displayFinalHand(p1);
			} else {
				System.out.println("Sorry " + p1.getName() + ", but the Dealer won");
				displayFinalHand(dealer);
			}
		}

	}

	private void displayFinalHand(Player p) {
		if (p.equals(p1)) {
			System.out.println(p1.getName() + "'s cards:");
			System.out.println(p1.getHand());
			System.out.println("Your final hand value was " + p1.getHandValue());
			System.out.println("---------------------------------------------------------------");
			System.out.println("Dealer's cards:");
			System.out.println(dealer.getHand());
			System.out.println(dealer.getName() + "'s final hand value was " + dealer.getHandValue());
		} else {
			System.out.println(dealer.getName() + "'s cards:");
			System.out.println(dealer.getHand());
			System.out.println(dealer.getName() + "'s final hand value was " + dealer.getHandValue());
			System.out.println("---------------------------------------------------------------");
			System.out.println(p1.getName() + "'s cards:");
			System.out.println(p1.getHand());
			System.out.println(p1.getName() + "'s final hand value was " + p1.getHandValue());
		}
	}

	private boolean checkBust(Player p) {
		boolean bust;
		if (p.equals(p1)) {
			bust = p1.bust();
			if (bust) {
				System.out.println("BUST " + p1.getName() + "...you lost.");
				displayFinalHand(p1);
			}
		} else {
			bust = dealer.bust();
			if (bust) {
				System.out.println("BUST " + dealer.getName() + " lost.");
				System.out.println(p1.getName() + ", You WON!!");
				displayFinalHand(dealer);
			}
		}

		return bust;
	}

	private boolean checkBlackjack(Player p) {
		boolean b;
		if (p.equals(p1)) {
			b = p1.blackjack();
			if (b) {
				System.out.println(p1.getName() + " you WON!!!");
				displayFinalHand(p1);
			}
		} else {
			b = dealer.blackjack();
			if (b) {
				System.out.println(p1.getName() + "...you lost.");
				System.out.println(dealer.getName() + " won.");
				displayFinalHand(dealer);
			}
		}

		return b;
	}

	private void dealCards(Player p) {
		// deal to player & show card
		if (p.equals(p1)) {
			p1.addToHand(deck.dealCard());
			System.out.println("Your cards:");
			displayHand(p1.getHand(), "Player");

			// show values so far
			System.out.println("Your hand's value is " + p1.getHandValue() + "\n");
		} else {
			// deal to dealer & don't show 1st card
			dealer.addToHand(deck.dealCard());
			System.out.println("Dealer cards:");
			displayHand(dealer.getHand(), "Dealer");
			System.out.println("The dealer's cards show " + dealer.dealerShowingValue() + "\n");
		}

	}

	private void displayHand(List<Card> hand, String playerType) {
		// show player's hand
		if (playerType.equalsIgnoreCase("Player")) {
			for (Card card : hand) {
				System.out.println(card.toString());
			}
			// show dealer's hand
		} else {
			for (int i = 0; i < hand.size(); i++) {
				if (i == 0) {
					System.out.println("First dealer card is HIDDEN");
				} else {
					System.out.println(hand.get(i));
				}
			}
		}
	}

	private char userChoice(char deal) {

		switch (deal) {
		case 'H':
			return deal;
		case 'S':
			return deal;
		}

		return deal;
	}

}
