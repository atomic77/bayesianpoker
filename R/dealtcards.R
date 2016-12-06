dealt.pair = 13 * choose(4,2) / choose(52,2);
samesuit = choose(13,2) * 4 / choose(52,2);
connected = 52 * 4 / choose(52,2);

# dealt  = {samesuit, connected, pair, other}
# hand = {nothing,pair,twopair,triple,straight,
	# flush,fullhouse,quad,straightflush}

phand = function (hand, dealt, n) {

  
}

# The mother of all prob functions!
phand.cond2 = function (hand, dealt, board, n) {
# Probability of a hand, given n cards and
# dealt a certain state and board is in a certain
# state

boardcombs = # function to get number of board combs we have
dealtcomb = # function to get number of dealt combs we have


handcombs = # Then figure out how many ways we can make the hand

phand.cond = handcombs / (boardcombs * dealtcombs);



}

# Example: P(trip | dealt = pair)

combs = 13*choose(4,2) * choose(39,3);
13*choose(4,3) * choose(39,2) / (13*choose(4,2) * choose(39,3))
# base:
13*choose(4,3) * choose(39,2) / (choose(52,5))

# Given pair, need to see one of two remaining cards

trip_given_pair = 2 / 50 + 2/49 + 2 / 48; # 0.122

# What about this??
13*choose(4,3) * choose(12,2) * 4^2  / 
  ( 13*choose(4,2) * choose(12,3) * 4^3)
