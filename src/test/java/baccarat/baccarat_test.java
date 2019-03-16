package baccarat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.model.cards.Card;
import com.model.cards.Deck;
import com.model.cards.Hand;
import com.model.cards.Rank;
import com.model.cards.Suit;

public class baccarat_test {

	@Test
	public void testCardCreation() {
		
		Card card = new Card(Rank.ACE, Suit.DIAMONDS);
		int value = card.getRank().getValue();
		
		assertEquals(value, 1);
	}
	
	@Test
	public void testHandScore() {
		
		Card card = new Card(Rank.ACE, Suit.DIAMONDS);
		Hand hand = new Hand("Player");
		hand.deal(card);
		hand.deal(card);
		int value = hand.getScore();
		
		assertEquals(value, 2);
		
		
	}
	
	@Test
	public void testDeckSingletonInstance() {
		
		Deck deck = Deck.getInstance();
		Deck anotherDeck = Deck.getInstance();
		
		assertEquals(deck, anotherDeck);
		
	}

}
