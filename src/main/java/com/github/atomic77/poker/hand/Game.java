package com.github.atomic77.poker.hand;

import java.util.ArrayList;
import java.util.List;

enum BettingRound {
    BLIND, FLOP, TURN, RIVER
}

public class Game {

    private CommunityCards communityCards;
    private List<Pocket> pockets;
    private BettingRound round;
    private Deck deck;
    private int numPlayers;
    private int id;

    public Game(int numPlayers, int id) {
        this.round = BettingRound.BLIND;
        this.numPlayers = numPlayers;
        this.deck = new Deck();
        this.id = id;
        pockets = new ArrayList<>(numPlayers);
    }

    public void nextRound() {
       switch (round) {
           case BLIND:
               communityCards =
                       new CommunityCards(deck.dealCards(3));
               round = BettingRound.FLOP;
               break;
           case FLOP:
               round = BettingRound.TURN;
               communityCards.addCard(deck.dealCard());
               break;
           case TURN:
               communityCards.addCard(deck.dealCard());
               round = BettingRound.RIVER;
               break;
       }
    }

    ////////////////////////
    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pocket> getPockets() {
        return pockets;
    }

    public void setPockets(List<Pocket> pockets) {
        this.pockets = pockets;
    }

    public BettingRound getRound() {
        return round;
    }

    public void setRound(BettingRound round) {
        this.round = round;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public CommunityCards getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(CommunityCards communityCards) {
        this.communityCards = communityCards;
    }
}
