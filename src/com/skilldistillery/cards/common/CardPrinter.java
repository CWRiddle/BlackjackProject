package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class CardPrinter {

	private List<Card> hand;
	
	public CardPrinter(List<Card> hand) {
		this.hand = hand;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void printHand() {
		
		System.out.print(printMultipleCards(0, hand.size(), false));
		
	}
	
	public void printHand(boolean isDealerHand) {
		if(isDealerHand)
			System.out.print(printMultipleCards(0, hand.size(), true));
		else
			System.out.print(printMultipleCards(0, hand.size(), false));
			
		
	}
	
	public String loadDealerCard() {
		
		String result =   ("+---------+\n"
		 		 		 + "| # # # # |\n"
		 		 		 + "|# # # # #|\n"
		 		 		 + "|###   ###|\n"
		 		 		 + "|##  ?  ##|\n"
		 		 		 + "|###   ###|\n"
		 		 		 + "|# # # # #|\n"
		 		 		 + "| # # # # |\n"
		 		 		 + "+---------+\n");
		
		
		return result;
	}
	
	public String loadSingleCard(int index) {
		
		String result =   ("+---------+\n"
				 		 + "|" + hand.get(index).getRankSymbol() + "        |\n"
				 		 + "|         |\n"
				 		 + "|         |\n"
				 		 + "|    "+ hand.get(index).getSuitSymbol() + "    |\n"
				 		 + "|         |\n"
				 		 + "|         |\n"
				 		 + "|        "+ hand.get(index).getRankSymbol() +"|\n"
				 		 + "+---------+\n");
		
		return result;
	}
	
	public void printSingleCard(int index) {
		
		//String result;
		
		//result = loadSingleCard(index);
		//result = concatCards(loadSingleCard(index));
		//result = printMultipleCards(0, 5);
		
		//System.out.println(result);
	}
	
	
	public String printMultipleCards(int index1, int index2, boolean isDealerCard) {
		
		List<StringBuilder> cardStrips = new ArrayList<>();
		int counter = 0;
		String card; 
		
		for(int i=0; i<(index2 - index1); i++) {
			if(isDealerCard == true && i == 0)
				card = loadDealerCard();
			else
				card = loadSingleCard(index1 + counter);
			String[] splitLines = card.split("\n");
			for(int j=0; j<splitLines.length; j++) {
				try {
					cardStrips.get(j).append(splitLines[j]);			
					
				}
				catch(IndexOutOfBoundsException e) {
					cardStrips.add(new StringBuilder(splitLines[j]));
				}
				
				}
			counter++;
			
		}
		StringBuilder result = new StringBuilder(); 
		
		for(int i=0; i<cardStrips.size(); i++) {
			
			result.append(cardStrips.get(i));
			result.append("\n");
		}
		
		return result.toString();
	}
	
	
}
