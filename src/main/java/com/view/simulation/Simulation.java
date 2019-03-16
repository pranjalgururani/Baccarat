package com.view.simulation;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.gamecontroller.*;

public class Simulation {

	public static void main(String[] args) {
		

		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter number of simulations");
		
		int times = userInput.nextInt();
		
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(0);
		results.add(0);
		results.add(0);
		results.add(0);
		
		GameController game = new GameController();
		
		while(times > 0) {
			
			game.gameStart();
			
			while(!game.gameOver()) {
				game.dealCards();
				game.checkScores();
				game.clearRound();
			}
			ArrayList<Integer> temp = game.endGame();
			for(int i =0; i<4; i++) {
				results.set(i, results.get(i)+temp.get(i));
			}
			
			times--;
		}

		double playerWins = (double)results.get(0)/(double)results.get(3);
		double bankerWins = (double)(results.get(1))/(double)results.get(3);
		double ties = (double)(results.get(2))/(double)results.get(3);
		
		System.out.printf("Player Win Probability : %.3f\n", playerWins);
		System.out.printf("Banker Win Probability : %.3f\n", bankerWins);
		System.out.printf("Ties Probability : %.3f\n", ties);
	}

}
