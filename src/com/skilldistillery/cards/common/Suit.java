package com.skilldistillery.cards.common;

public enum Suit {

	SPADES("SPADES", '\u2660'), CLUBS("CLUBS", '\u2663'), DIAMONDS("DIAMONDS", '\u2666'), HEARTS("HEARTS", '\u2665');
	
	private String name;
	private char suitSymbol;
	
	Suit(String name, char suitSymbol){
		this.name = name;
		this.suitSymbol = suitSymbol;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSuit() {
		return this.getName();
	}
	
	public String getSuitSymbol() {
		String symbol = String.valueOf(this.suitSymbol);
		return symbol;
	}
	
}
