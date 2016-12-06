######################################################
# Alex Tomic
# Uncertain Reasoning / Data Mining
# Dec 2, 2010
# A collection of functions for calculating the priors
# for a few classes of poker hands
######################################################

# # For three cards
# rainbow.3 = 4* 13^3 / choose(52,3);
# suit.3 = 4 * choose(13,3) / choose(52,3);
# 
# # Approximation -- assumes wrapping cards
# straight3.3 = 4 * (12 * 4 * 4 ) / choose(52,3) ;
# 
# # 48 possible starting cards
# sf.3 = 48 / choose(52,3)
# triple.3 = 52 / choose(52,3)
# pair.3 = (choose(12,(3-1))*13*choose(4,2)) / choose(52,3); # corr!
# 

# ########################
# After 4 cards
rainbow.4 = 13^4 / choose(52,4);
suit.4 = 4 * choose(13,3) / choose(52,3);
#straight3.4 = 4 * (12 * 4 * 4 ) / choose(52,3) ;
straight4.4 = 4 * (11 * 4 * 4 * 4) / choose(52,4) 
triple.4 = 13*12*11 / choose(52,4) # vrong
twopair.4 =  3*(13 * 12)*choose(4,2) / choose(52,4); # corr, but why 3*?

# Functions
triple.n = function(n) {
  # cominbations of suits and ranks for triple
  ranks = 13;o
  suits = choose(4,3);
  # combinations for remainder
  ranks.rem = choose(12,n-3);
  suits.rem = 4^(n-3);
  totcomb = choose(52,n);
  triple.n = (ranks*suits*ranks.rem*suits.rem) / totcomb;
}

pair.n = function (n) {
  pair.n = (choose(12,(n-2))*13*choose(4,2) * 4^(n-2)) / choose(52,n) # corr!
}

twopair.n = function(n) {
  # cominbations of suits and ranks for triple
  ranks = choose(13,2);
  suits = choose(4,2)^2;
  # combinations for remainder
  ranks.rem = choose(11,n-4);
  suits.rem = 4^(n-4);
  totcomb = choose(52,n);
  twopair.n = ranks * suits * ranks.rem * suits.rem / totcomb;
}

rainbow.n = function(n) {
  ranks = 13^n;
  suits = choose(4,(4-n))
  rainbow.n = ranks * suits/ choose(52,n);
}

suit.n = function(n,len) {
  ranks = choose(13,n);
  suits = 4;
#   ranks.rem = choose( 13, len-n);
#   suits.rem = 3^(len-n);
  cards.rem = choose(39,len-n);
  suit.n = ranks * suits * cards.rem  / choose(52,len);
}
sf.n = function(n) {
  sequences = 12 - (n-3);
  suits = 4;

  sf.n = sequences * suits / choose(52,n);
}
consec.n = function(n,len) {
  # Defined as : n cards such that one additional card can
  # make n+1 cards of consecutive rank
  # FIX
  #4 * (12 * 4 * 4 ) / choose(52,3) ;
  sequences = 12 - (n-3);
  suits = 4^n;
  rem = len - n;
#(11 * 4^3 * 46) / choose(52,4)
  #ranks.rem = choose(13,rem);
  cards.rem = choose(52 - len - n, rem);
  totcomb = choose(52,len);
  straight.n = sequences * suits * cards.rem / totcomb;
}
