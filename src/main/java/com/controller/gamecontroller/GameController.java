package com.controller.gamecontroller;

import java.util.ArrayList;
import java.util.LinkedList;

import com.model.cards.Card;
import com.model.cards.Deck;
import com.model.cards.Hand;

public class GameController {

	private LinkedList<Card> gameQueue;

	private Hand playerHand;
	private Hand bankerHand;

	private int playerScore, bankerScore;
	private int playerWins, bankerWins;

	private int tieCounts;

	public GameController() {
		gameQueue = new LinkedList<Card>();

		playerHand = new Hand("Player");
		bankerHand = new Hand("Banker");
	}

	public void gameStart() {

		playerScore = 0;
		bankerScore = 0;
		playerWins = 0;
		bankerWins = 0;

		tieCounts = 0;

		Deck tempDeck = Deck.getInstance();
		ArrayList<Card> deck = tempDeck.getDeck();

		for (int i = 0; i < deck.size(); i++) {

			gameQueue.add(deck.get(i));

		}

	}

	public boolean gameOver() {
		if (gameQueue.size() < 6)
			return true;

		return false;
	}

	public void compareHands() {

		playerScore = playerHand.getScore();
		bankerScore = bankerHand.getScore();

		if (playerScore > bankerScore) {
			playerWins++;
			System.out.println("Player Wins!");
		} else if (bankerScore > playerScore) {
			bankerWins++;
			System.out.println("Banker Wins!");
		} else {
			tieCounts++;
			System.out.println("Its a tie!");
		}
		System.out.println("###########################");
	}

	public void checkScores() {

		playerScore = playerHand.getScore();
		bankerScore = bankerHand.getScore();

		if (playerScore > 7 || bankerScore > 7)
			compareHands();
		else {
			if (playerScore >= 0 && playerScore <= 5) {

				playerHand.deal(gameQueue.poll());

				int draw = playerHand.getLast();
				if (draw == 2 || draw == 3) {

					if (bankerScore >= 0 && bankerScore <= 4)
						bankerHand.deal(gameQueue.poll());
				} else if (draw == 4 || draw == 5) {
					if (bankerScore >= 0 && bankerScore <= 5)
						bankerHand.deal(gameQueue.poll());
				} else if (draw == 6 || draw == 7) {
					if (bankerScore >= 0 && bankerScore <= 6)
						bankerHand.deal(gameQueue.poll());
				} else if (draw == 8) {
					if (bankerScore >= 0 && bankerScore <= 2)
						bankerHand.deal(gameQueue.poll());
				} else {
					if (bankerScore >= 0 && bankerScore <= 3)
						bankerHand.deal(gameQueue.poll());
				}

			} else if (bankerScore >= 0 && playerScore <= 5) {
				bankerHand.deal(gameQueue.poll());
			}

			compareHands();
		}
	}

	public void dealCards() {
		playerHand.deal(gameQueue.poll());
		bankerHand.deal(gameQueue.poll());
		playerHand.deal(gameQueue.poll());
		bankerHand.deal(gameQueue.poll());
	}

	public ArrayList<Integer> endGame() {

		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(playerWins);
		results.add(bankerWins);
		results.add(tieCounts);
		results.add(playerWins + bankerWins + tieCounts);

		return results;
	}

	public void clearRound() {
		playerHand.clear();
		bankerHand.clear();
	}

}
