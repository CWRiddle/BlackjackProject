package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand {

	private List<Card> hand;
	private int handValue = 0;
	private String name;
	
	public BlackJackHand(String name) {
		hand = new ArrayList<>();
		this.name = name;
	}
	
	public void addCard(Card card) {
		hand.add(card);
		handValue += card.getValue();
	}
	
	public int getValue() {
		return this.handValue;
	}
	
	public int getNumCardsInHand() {
		return hand.size();
	}
	
	public Card getCardFromHand(int index) {
		return hand.get(index);
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Card> getHand(){
		return this.hand;
	}
	
}
