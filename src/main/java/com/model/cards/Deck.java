package com.model.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

public static volatile Deck instance = null;
	
	private ArrayList<Card> deck = createDeck();
	
	private Deck() {
		
	}
	
	public static Deck getInstance() {
		
		if(instance == null) {
			synchronized(Deck.class) {
				
				instance = new Deck();
			}
		}
		return instance;
	}
	
	private static ArrayList<Card> createDeck(){
		
		ArrayList<Card> localDeck = new ArrayList<Card>();
		
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()){
				localDeck.add(new Card(rank, suit));
			}
		}
		localDeck = shuffleDeck(localDeck);
		return localDeck;
	}
	
	public static ArrayList<Card> shuffleDeck(ArrayList<Card> localDeck){
		
		Collections.shuffle(localDeck);
		return localDeck;
	}
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
}
