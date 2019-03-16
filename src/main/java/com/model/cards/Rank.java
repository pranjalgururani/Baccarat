package com.model.cards;

public enum Rank {

	ACE(1),
	KINGS(0),
	QUEEN(0),
	JACK(0),
	TEN(0),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9);
	
	private int rank;
	
	private Rank(int rank) {
		this.rank = rank;
	}
	
	public int getValue() {
		return this.rank;
	}
}
