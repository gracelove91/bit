package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import test.Test.Rank;
import test.Test.Suit;

public class Test {
	enum Suit {
		CLUB, DIAMOND, HEART, SPADE
	}

	enum Rank {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	static Collection<Suit> suits = Arrays.asList(Suit.values());
	static Collection<Rank> ranks = Arrays.asList(Rank.values());
	
	
	public static void main(String[] args) {
		List<Card> deck = new ArrayList<>();
		for (Suit suit : suits) {
			for (Rank r : ranks) {
				deck.add(new Card(suit,r));
			}
		}
	}
}

class Card {
	final Suit suit;
	final Rank rank;
	
	Card(Suit suit, Rank rank){
		this.suit = suit;
		this.rank = rank;
	}
}
class Deck{

}