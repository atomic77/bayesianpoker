######################################################
# Alex Tomic
# Uncertain Reasoning / Data Mining
# Dec 2, 2010
# Functions for generating and recognising different
# hands
######################################################


MAX_TRIES = 10;
evaluatehand = function(h) {
  h = sort(h);
  # We want everything 1-index based
  suits = getsuits(h); 
  ranks = getranks(h); 
  # DEBUG
  #print(suits);
  #print(ranks);
  if (isstraightflushN(suits, ranks, 5)) {
    return("straightflush");
    #return(1);
  } else if (isquad(suits, ranks)) {
    return("quad");
    #return(2);
  } else if (isfullhouse(suits, ranks)) {
    return("fullhouse");
    #return(3);
  } else if (isflushN(suits, ranks, 5)) {
    return("flush");
    #return(4);
  } else if (isstraightN(suits, ranks, 5)) {
    return("straight");
    #return(5);
  } else if (istriple(suits, ranks)) {
    return("triple");
    #return(6);
  } else if (istwopair(suits, ranks)) {
    return("twopair");
    #return(7);
  } else if (ispair(suits, ranks)) {
    return("pair");
    #return(8);
  } else { 
    return("nothing");
    #return(9);
  } 

}

getsuits = function(h) {
 return(ceiling(h/13)); 
}

getranks = function(h) {
#   return( (h %% 13) + 1);
  return(((h-1) %% 13) + 1);

}

# isstraightflush = function(suits, ranks)  {
isstraightflushN = function(suits, ranks, n)  {
	# Since the vast majority of hands are not SFs, but we
	# always have to check, try to exit as soon as possible	
	# and use a more expensive computation if we have both
	if (!isflushN(suits, ranks, n)) { return(FALSE);}
	if (!isstraightN(suits, ranks, n)) { return(FALSE);}

	# We have a straight and a flush, but we're not done, since
	# we need to verify that they're over the same set of cards
	h = gethandfromsuitsranks(suits, ranks);
  for (s in 1:4) {
    if (sum(suits == s) >= n) {
			#print("Flush set");
			flush.set = h * as.integer(suits==s);
			#print(flush.set);
			flush.set = flush.set[flush.set != 0];
			if(isstraightN(getsuits(flush.set), getranks(flush.set),n)) { 
	      return(TRUE);
			}
    }
  }
	return(FALSE);
}

isquad = function(suits, ranks) {
  # Not efficient, but quick to implement...
  for (r in 1:13) {
    if (sum(ranks == r) == 4) {
      return(TRUE);
    }
  }
  return(FALSE);
}

isfullhouse = function(suits, ranks) {
  # Not efficient, but quick to implement...
  hastriple = FALSE;
  haspair = FALSE;
  for (r in 1:13) {
    if (sum(ranks == r) == 3) {
      hastriple = TRUE;
    } else if (sum(ranks == r) == 2) {
      haspair = TRUE;
    }
  }
  return(haspair && hastriple);
}
isflushN = function(suits, ranks, n) {
  for (s in 1:4) {
    if (sum(suits == s) >= n) {
      return(TRUE);
    }
  }
  return(FALSE);
}

isstraightN = function(suits, ranks,n) {
  # We don't care about the suits
  ranks = sort(ranks);
  return(hasstraightN(c(),ranks, n));

}

hasstraightN = function(suits, ranks, n) {
  subseqsize = 0;
  for (r in 1:(length(ranks)-1)) {
    if (ranks[r+1] - ranks[r] == 1) {
      subseqsize = subseqsize + 1;

    } else {
      subseqsize = 0;
    }
    if (subseqsize >= (n-1)) { return(TRUE); }
  }
  return(FALSE);
}

istriple = function(suits, ranks) {
  # Not efficient, but quick to implement...
  for (r in 1:13) {
    if (sum(ranks == r) == 3) {
      return(TRUE);
    }
  }
  return(FALSE);
}

istwopair = function(suits, ranks) {
  # Not efficient, but quick to implement...
  numpairs = 0;
  for (r in 1:13) {
    if (sum(ranks == r) == 2) {
      numpairs = numpairs + 1;
    }
  }
  return(numpairs >= 2);
}
ispair = function(suits, ranks) {
  # Not efficient, but quick to implement...
  for (r in 1:13) {
    if (sum(ranks == r) == 2) {
      return(TRUE);
    }
  }
  return(FALSE);
}

gethandfromsuitsranks = function(suits, ranks) {
  return((suits-1) * 13 + ranks);

}
generaterandompocket = function(size=2,type) {
# Types
# samesuit,connected,pair,other
  if (type == "samesuit") {
    suit = sample(4,1) ;
    suits = c(suit,suit);
    ranks = sample(13,2) ;
  } else if (type == "connected") {
    suits = sample(4,2,replace=TRUE);
    firstrank = sample(12,1);
    ranks = c(firstrank, firstrank+1);
  } else if (type == "pair") {
    rank = sample(13,1);
    suits = sample(4,2,replace=FALSE);
    ranks = c(rank, rank);
  } else if (type == "other") {
    # In practice we'll compute these as 1 - (the rest) so just return 
    # anything here
    return(sample(52,2));
  }

  return(gethandfromsuitsranks(suits, ranks));
}

generaterandomboard = function(size=3,type) {

  if (type == "suit3") {
    return(generatesuited(size,3));
  } else if (type == "suit4") {
    return(generatesuited(size,4));
  } else if (type == "rainbow") {
    return(generaterainbow(size));
  } else if (type == "straight3") {
    return(generatestraight(size,3));
  } else if (type == "straight4") {
    return(generatestraight(size,4));
  } else if (type == "triple") {
    return(generatetriple(size));
  } else if (type == "twopair") {
    return(generatetwopair(size));
  } else if (type == "pair") {
    return(generatepair(size));
  } else if (type == "sf3") {
     return(generatesf3(size));
  } else if (type == "other") {
    # As with pocket, we'll ignore this in practice.. just return
    # a random board
    return(sample(52,size));
  }
  
  return(gethandfromsuitsranks(suits, ranks));
}

generatesuited = function(size, n)  {
    suitn = sample(4,1);
    ranksn = sample(13,n);
    suitsn = rep(suitn,n);
    handn = gethandfromsuitsranks(suitsn, ranksn);
    if (size > n) {
      rem = size - n;
      # Choose from remaining 39 other-suited cards
      removed.cards = ((suitn-1)*13+1):((suitn)*13);
      rem.deck = setdiff(1:52, removed.cards);
      #suit.rem = sample( setdiff(1:4,suit3),rem);
      hand.rem = sample(rem.deck, size-n);
      handn = c(handn, hand.rem);
    }
    return(handn);
}

generatesf3 = function(size)  {
    suit = sample(4,1);
		# We can make a straight from up to 11 only
    rank = sample(11,1);
		suits = rep(suit, 3);
		ranks = rank:(rank+2);
		handn = gethandfromsuitsranks(suits, ranks);
    if (size > 3) {
      rem = size - 3;
      # Choose from remaining cards
      rem.deck = setdiff(1:52, handn);
      #suit.rem = sample( setdiff(1:4,suit3),rem);
      hand.rem = sample(rem.deck, size-3);
      handn = c(handn, hand.rem);
    }
    return(handn);
}

generaterainbow = function(n) {
  suits = 1:4;
  if (n < 4) { suits = sample(4,n);}
  ranks = sample(13,n,replace=FALSE);
  return(gethandfromsuitsranks(suits,ranks));
}

israinbow = function(suits, ranks) {
  for (s in 1:4) {
    if (sum(suits == s) > 1) {
      return(FALSE);
    }
  }
  return(TRUE);
}

generatestraight = function(size, n) {
  # TODO This seems still to generate some spurious straights longer than > n
  rank.start = sample(13-n,1);
  ranks.str = rank.start:(rank.start+n-1);
  suits.str = sample(4,n,replace=TRUE);
  hand.str = gethandfromsuitsranks(suits.str, ranks.str);

  if (size > n) {
    rem = size - n;
    # We'll calculate the range of ranks that need to be removed
    rank.rem.start = max(1,rank.start-1);
    rank.rem.end = min(13,rank.start+n);
    ranks.rem = rank.rem.start:rank.rem.end;
    removed.cards = c(1*ranks.rem, 2*ranks.rem, 3*ranks.rem, 4*ranks.rem);
    rem.cards = setdiff(1:52, removed.cards);
    # sample the remaining cards
    hand.rem = sample(rem.cards,rem);
    hand.str = c(hand.str, hand.rem);
  }
  return(hand.str);
}

getcardsforrank = function(rank) {
  ranks = rep(rank, 4);
  suits = 1:4;
  return(gethandfromsuitsranks(suits,ranks));
}

generatetriple = function(n) {

  rank.trip = sample(13,1);
  ranks.trip = rep(rank.trip,3);
  suits.trip = sample(4,3);
  hand.trip = gethandfromsuitsranks(suits.trip, ranks.trip);
  if (n > 3) {
    excl.cards = getcardsforrank(rank.trip);
    cards.rem = setdiff(1:52, excl.cards);
    hand.rem = sample(cards.rem, n-3);
    # Make sure we don't draw a full house
    while(ispair(getsuits(hand.rem), getranks(hand.rem))) {
      hand.rem = sample(cards.rem, n-3);
    }
    hand.trip = c(hand.trip, hand.rem);
  }
  return(hand.trip);
}

generatepair = function(n) {
  rank.pair = sample(13,1);
  ranks.pair = rep(rank.pair,2);
  suits.pair = sample(4,2);
  hand.pair = gethandfromsuitsranks(suits.pair, ranks.pair);
  if(n > 2) {
    excl.cards = getcardsforrank(rank.pair);
    #print(excl.cards);
    cards.rem = setdiff(1:52,excl.cards);
    hand.rem = sample(cards.rem,n -2);
    # We need to make sure we didn't just sample a
    # fullhouse or two pair 
    # print(hand.rem);
    if(n >= 4) {
      while(istriple(getsuits(hand.rem), getranks(hand.rem)) 
	    || ispair(getsuits(hand.rem), getranks(hand.rem))) {
	hand.rem = sample(cards.rem,n -2);
      }
    }
    hand.pair = c(hand.pair, hand.rem);	
 
  }
  return(hand.pair);
}

generatetwopair = function(n) {
  rank.pairs = sample(13,2);
  ranks.pairs = c(rep(rank.pairs[1],2), rep(rank.pairs[2],2));
  suit.pairs = sample(4,2);
  suits.pairs = rep(suit.pairs,2);
  hand.pair = gethandfromsuitsranks(suits.pairs, ranks.pairs);
  if (n >= 5) {
    excl.cards = c(getcardsforrank(rank.pairs[1]),
		    getcardsforrank(rank.pairs[2]));
    cards.rem = setdiff(1:52,excl.cards);
    hand.rem = sample(cards.rem, n-4);
    hand.pair = c(hand.pair, hand.rem);
  }
  return(hand.pair);
}


# Similar to the evaluatehand() function, we also need a way to evaluate
# boards in order to run montecarlo estimations of the conditional
# probabilities for transitions from one board to another
evaluateboard = function(h) {
  h = sort(h);
  # We want everything 1-index based
  suits = getsuits(h); 
  ranks = getranks(h); 
  # DEBUG
  #print(suits);	#	res = evaluateboard(c(brd, nextcard));
  #print(ranks);
  # Luckily we can reuse many of the functions for hands
  if (isstraightflushN(suits, ranks,3)) {
    return("sf3");
  } else if (istriple(suits, ranks) || isquad(suits, ranks)) {
    return("triple");
  } else if (isstraightN(suits, ranks, 4)) {
    return("straight4");
  } else if (isstraightN(suits, ranks, 3)) {
    return("straight3");
  } else if (isflushN(suits, ranks, 4)) {
    return("suit4");
  } else if (isflushN(suits, ranks, 3)) {
    return("suit3");
  } else if (israinbow(suits, ranks)) {
    return("rainbow");
  } else if (istwopair(suits, ranks)) {
    return("twopair");
  } else if (ispair(suits, ranks)) {
    return("pair");
  } else { 
    return("other");
  } 

}
