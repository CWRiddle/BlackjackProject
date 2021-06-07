package com.skilldistillery.cards.common;

public enum Suit {

	SPADES("SPADES"), CLUBS("CLUBS"), DIAMONDS("DIAMONDS"), HEARTS("HEARTS");
	
	public String name;
	
	Suit(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSuit() {
		return this.getName();
	}
	
}
