package com.skilldistillery.cards.common;

public enum Rank {

	ACE(1, "ACE", "A"), TWO(2, "TWO", "2"), THREE(3, "THREE", "3"), FOUR(4, "FOUR", "4"), FIVE(5, "FIVE", "5"), SIX(6, "SIX", "6"), SEVEN(7, "SEVEN", "7"), EIGHT(8, "EIGHT", "8"), NINE(9, "NINE", "9"), TEN(10, "TEN", "10"), JACK(10, "JACK", "J"), QUEEN(10, "QUEEN", "Q"), KING(10, "KING", "K");
	
	private int value;
	private String name;
	private String rankSymbol;
	
	Rank(int value, String name, String rankSymbol){
		this.value = value;
		this.name = name;
		this.rankSymbol = rankSymbol;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}

	public String getRank() {
		return this.getName();
	}
	
	public String getRankSymbol() {
		return this.rankSymbol;
	}
	
}
