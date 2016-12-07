package com.github.atomic77.poker.hand;

import org.apache.commons.math3.random.RandomData;
import org.apache.commons.math3.random.RandomDataImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by atomic on 12/5/16.
 */
public class GameTest {

    static RandomData randomData = new RandomDataImpl();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void simulateGameTest() throws Exception {
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

    @Test
    public void pokerTest() throws Exception {
//        int n = 1000*1000;
        int n = 10000;
        int [] handCounts = new int[9];
        for (int i=0; i< 9; i++) handCounts[i] = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            Hand h = Hand.generateRandomHand(7, randomData);
            int val = h.evaluateHand();
            handCounts[val]++;
        }

        long end = System.currentTimeMillis();
        System.out.printf("Runtime %.2f s. Evaluated avg %.3f hands / ms \n",
                (double)(end - start) / 1000, (double) n /(end - start));
        System.out.println("Histogram:");
        for (int i = 0; i<9; i++) {
            System.out.println(i + ": " + handCounts[i] );
        }

    }

}