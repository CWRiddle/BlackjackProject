package com.skilldistillery.cards.common;

public class Card {

	Suit suit;
	Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getValue(){
		return this.rank.getValue();
	}
	
	public String getSuit() {
		return this.suit.getSuit();
	}
	
	public String getRank() {
		return this.rank.getRank();
	}
	
	public String getRankSymbol() {
		return this.rank.getRankSymbol();
	}
	
	public String getSuitSymbol() {
		return this.suit.getSuitSymbol();
	}
	
	@Override
	public String toString() {
		return this.getRank() + " of " + this.getSuit();
	}
	
	public void printCardTester() {
		
		
		
		
	}

	
}
