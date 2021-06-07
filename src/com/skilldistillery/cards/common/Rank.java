package com.skilldistillery.cards.common;

public enum Rank {

	ACE(1, "ACE"), TWO(2, "TWO"), THREE(3, "THREE"), FOUR(4, "FOUR"), FIVE(5, "FIVE"), SIX(6, "SIX"), SEVEN(7, "SEVEN"), EIGHT(8, "EIGHT"), NINE(9, "NINE"), TEN(10, "TEN"), JACK(10, "JACK"), QUEEN(10, "QUEEN"), KING(10, "KING");
	
	private int value;
	private String name;
	
	Rank(int value, String name){
		this.value = value;
		this.name = name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getName() {
		return name;
	}

	public String getRank() {
		return this.getName();
	}
	
}
