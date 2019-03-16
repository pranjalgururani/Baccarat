package com.model.cards;

import java.util.*;

public class Hand {
	
	LinkedList<Card> hand;
	String name;
	
	public Hand(String name) {
		
		this.name = name;
		hand = new LinkedList<Card>();
	}
	
	public void deal(Card card) {
		hand.add(card);
		
		System.out.println(this.name + " draws " + card.getRank().getValue());
	}
	
	public int getScore() {
		int score =0;
		
		for(int i =0; i<hand.size(); i++) {
			score+= hand.get(i).getRank().getValue();
		}
		
		while(score >10)
			score -=10;
		
		return score;
	}
	
	public int getLast() {
		return hand.get(2).getRank().getValue();
	}
	
	public void clear() {
		hand.clear();
	}

}
