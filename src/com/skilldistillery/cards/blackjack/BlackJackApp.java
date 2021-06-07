package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.BlackJackHand;
import com.skilldistillery.cards.common.CardPrinter;
import com.skilldistillery.cards.common.Deck;

public class BlackJackApp {

	public static void main(String[] args) {
		
		
		//Variables
		Scanner kb = new Scanner(System.in);
		int hitOrStay = 1;
		Deck deck = new Deck();
		BlackJackHand playerHand = new BlackJackHand("Player");
		BlackJackHand dealerHand= new BlackJackHand("Dealer");
		
		List<BlackJackHand> hands = new ArrayList<>();
		
		hands.add(dealerHand);
		hands.add(playerHand);
		
		CardPrinter cardPrinter;
		
		//Play Game
		deck.shuffle();
		
		//Deals Initial Cards
		playerHand.addCard(deck.deal());
		dealerHand.addCard(deck.deal());
		
		playerHand.addCard(deck.deal());
		dealerHand.addCard(deck.deal());
		
		//Shows Initial Hands
		displayHand(playerHand, false);
		displayHand(dealerHand, true);

		//Player Hit or Stay
		while(hitOrStay != 0) {
		System.out.println("Enter 1 to hit or 0 to stay: ");
			hitOrStay = kb.nextInt();
			
			//adds card to hand if hit and shows hand
			if(hitOrStay > 0) {
				playerHand.addCard(deck.deal());
			}
			displayHand(playerHand,false);
			
			//checks bust condition
			if(playerHand.getValue() > 21) {
				displayHand(playerHand, false);
				System.out.println("Bust!");
				System.out.println("Game Over!");
				break;
			}
		}
		
		if(!(playerHand.getValue() > 21)) {
		//Dealer Plays
		//Draws card if hand is below 17
			while(dealerHand.getValue() < 17) {
				dealerHand.addCard(deck.deal());
			}
			//checks bust condition
			if(dealerHand.getValue() > 21) {
				displayHand(dealerHand, false);
				System.out.println("Bust!");
				System.out.println("Game Over. Player Wins!");
			}
		}
		
		//Win Conditions
		if(dealerHand.getValue() > 21 || playerHand.getValue() > 21) {
			if(dealerHand.getValue() > playerHand.getValue()) {
				System.out.println("Dealer wins!");
			}
			else
				System.out.println("Player wins!");
			
			System.out.println("Game Over!");
		}

	}
	
	
	public static void displayHand(BlackJackHand hand, boolean isDealerHand) {
		
			System.out.println("\n" + hand.getName() +" Hand:");
			System.out.println("------------");
			for(int currentCard = 0; currentCard < hand.getNumCardsInHand(); currentCard++) {
				if(isDealerHand && currentCard == 0) {
					System.out.println("[************]");
				}
				else
					System.out.println(hand.getCardFromHand(currentCard).toString());
			}
			CardPrinter cardPrinter = new CardPrinter(hand.getHand());
			cardPrinter.printHand(isDealerHand);
			System.out.println("Total: " + hand.getValue());
	}
	
	
	
}
