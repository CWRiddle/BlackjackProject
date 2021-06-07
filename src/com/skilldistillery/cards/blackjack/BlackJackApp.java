package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.BlackJackHand;
import com.skilldistillery.cards.common.CardPrinter;
import com.skilldistillery.cards.common.Deck;

public class BlackJackApp {

	public static void main(String[] args) {
		
		BlackJackApp app = new BlackJackApp();
		app.run();
		
	}
	
	private void run() {
		
		// Variables
		Scanner kb = new Scanner(System.in);
		int hitOrStay;
		Deck deck;
		BlackJackHand playerHand;
		BlackJackHand dealerHand;
		CardPrinter cardPrinter;

		while (true) {
			//Initialize "Fields"
			deck = new Deck();
			playerHand = new BlackJackHand("Player");
			dealerHand = new BlackJackHand("Dealer");
			deck.shuffle();
			// Deal Initial Cards
			playerHand.addCard(deck.deal());
			dealerHand.addCard(deck.deal());
			playerHand.addCard(deck.deal());
			dealerHand.addCard(deck.deal());
			// Display Initial Hands
			displayHand(dealerHand, true);
			displayHand(playerHand, false);
			//Play Game
			playGame(dealerHand, playerHand, deck, kb);
			//Prompt to Keep Playing
			System.out.print("Type quit to exit or Enter to play again: ");
			kb.nextLine();
			String input = kb.nextLine();
			
			if (input.equals("quit"))
				break;
		}
		System.out.println("Program ended.");
		kb.close();
	}
	
	private void playGame(BlackJackHand dealerHand, BlackJackHand playerHand, Deck deck, Scanner kb) {
		
		if(!playerPlays(playerHand, deck, kb)) {
			System.out.println("Player Busts! \nGame Over!");
		}
		else if(!dealerPlays(dealerHand, deck, kb)) {
			if(playerHand.getValue() <= 21){
				System.out.println("Dealer Busts! Player Wins! \nGame Over!");
			}
			else
				System.out.println("Dealer Busts! \nGame Over!");
		}else if(dealerHand.getValue() > playerHand.getValue()) {
			System.out.println("Dealer has a higher hand. Dealer wins! \nGame Over!");
		}
		else
			System.out.println("Player has a higher hand. Player wins! \nGame Over!");
	}

	private boolean dealerPlays(BlackJackHand dealerHand, Deck deck, Scanner kb) {
		
		while (dealerHand.getValue() < 17) {
			displayHand(dealerHand, true);
			System.out.println("Press Enter to see Dealers next move.");
			kb.nextLine();
			kb.nextLine();
			dealerHand.addCard(deck.deal());
			displayHand(dealerHand, true);
		}
		// checks bust condition
		if (dealerHand.getValue() > 21) {
			displayHand(dealerHand, false);
			return false;
		}
		return true;
	}
	
	private boolean playerPlays(BlackJackHand playerHand, Deck deck, Scanner kb) {
		int hitOrStay = -1;
		
		while (hitOrStay != 0) {
			System.out.println("\nEnter 1 to hit or 0 to stay: ");
			hitOrStay = kb.nextInt();

			// adds card to hand if hit and shows hand
			if (hitOrStay > 0) {
				playerHand.addCard(deck.deal());
				displayHand(playerHand, false);
			}

			// checks bust condition
			if (playerHand.getValue() > 21) {
				//displayHand(playerHand, false);
				return false;
			}
		}
		return true;
	}
	
	private void displayHand(BlackJackHand hand, boolean isDealerHand) {

		System.out.println("-------------+");
		System.out.println(hand.getName() + " Hand:" + " |");
		System.out.println("-------------+");
		for (int currentCard = 0; currentCard < hand.getNumCardsInHand(); currentCard++) {
			System.out.print(" - ");
			if (isDealerHand && currentCard == 0) {
				System.out.println("[??????????]");
			} else
				System.out.println(hand.getCardFromHand(currentCard).toString());
		}
		CardPrinter cardPrinter = new CardPrinter(hand.getHand());
		cardPrinter.printHand(isDealerHand);
		System.out.println("----------+");
		System.out.println("Total: " + hand.getValue() + " |");
		System.out.println("----------+");
	}

}
