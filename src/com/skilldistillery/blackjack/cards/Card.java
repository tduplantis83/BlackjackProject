package com.skilldistillery.blackjack.cards;

public class Card {

	private String suit;
	private int rank;
	private String rankName;
	private int softValue;

	public Card(Suit s, Rank r) {
		this.rank = r.getRank();
		this.suit = s.toString();
		this.rankName = r.getRankName();
		this.softValue = r.getSoftRank();
	}

	public int getValue() {
		return this.rank;
	}
	
	public String getRankName() {
		return this.rankName;
	}
	
	public int getSoftValue() {
		return this.softValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rankName);
		builder.append(" of ");
		builder.append(suit);
		builder.append(" (worth: ");
		builder.append(rank);
		if(softValue != 0) {
			builder.append("/" + softValue);
		}
		builder.append(")");
		return builder.toString();
	}

}
