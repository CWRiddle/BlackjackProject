package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.BlackJackHand;
import com.skilldistillery.cards.common.Deck;

public class BlackJackApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int hitOrStay = 1;
		
		Deck deck = new Deck();
		BlackJackHand playerHand = new BlackJackHand("Player");
		BlackJackHand dealerHand= new BlackJackHand("Dealer");
		
		List<BlackJackHand> hands = new ArrayList<>();
		
		hands.add(dealerHand);
		hands.add(playerHand);
		
		deck.shuffle();
		
		playerHand.addCard(deck.deal());
		dealerHand.addCard(deck.deal());
		
		playerHand.addCard(deck.deal());
		dealerHand.addCard(deck.deal());
		
		displayHand(playerHand);
		displayHand(dealerHand);
		
		while(hitOrStay != 0) {
		System.out.println("Enter 1 to hit or 0 to stay: ");
			hitOrStay = kb.nextInt();
			
			if(hitOrStay > 0) {
				playerHand.addCard(deck.deal());
			}
			displayHand(playerHand);
		}
		
		while(dealerHand.getValue() < 17) {
			dealerHand.addCard(deck.deal());
		}
		
		displayHand(playerHand);
		displayHand(dealerHand);
		
		if(dealerHand.getValue() > 21) {
			System.out.println("Dealer bust!");
		}
		if(playerHand.getValue() > 21) {
			System.out.println("Player bust!");
		}
		
		
	}
	
	
	public static void displayHand(BlackJackHand hand) {
		
			System.out.println("\n" + hand.getName() +" Hand:");
			System.out.println("------------");
			for(int j=0; j<hand.getNumCardsInHand(); j++) {
				System.out.println(hand.getCardFromHand(j).toString());
			}
			System.out.println("Total: " + hand.getValue());
	}
	
	
	
}
