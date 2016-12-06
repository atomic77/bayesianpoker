package ch.usi.tomica.poker;

import ch.usi.tomica.poker.hand.Card;
import ch.usi.tomica.poker.hand.CommunityCards;
import ch.usi.tomica.poker.hand.Deck;
import ch.usi.tomica.poker.hand.Hand;
import ch.usi.tomica.poker.hand.Pocket;

public class SimulateGame {

	
	public static void main(String[] args) {
		Deck d = new Deck();
		Pocket opp = d.dealPocket(2);
		Pocket me = d.dealPocket(2);
		CommunityCards board = d.dealCommunityCards(3);
		System.out.println("Opponent cards: " + opp);
		System.out.println("My cards: " +  me);
		System.out.println("Flop Board cards: " +  board);
		board.addCard(d.dealCard());
		System.out.println("Turn Board cards: " +  board);
		board.addCard(d.dealCard());
		System.out.println("River Board cards: " +  board);
		System.out.println(d.numCards());
		Hand oppHand = new Hand();
		Hand myHand = new Hand();
		oppHand.addCards(opp);
		oppHand.addCards(board);
		myHand.addCards(me);
		myHand.addCards(board);
		System.out.println("My hand: " +  myHand 
				+ "\n\tValue: " + Hand.getHandStr(myHand.evaluateHand()));
		
		System.out.println("Opp hand: " +  oppHand 
				+ "\n\tValue: " + Hand.getHandStr(oppHand.evaluateHand()));
		
		
	}

}
