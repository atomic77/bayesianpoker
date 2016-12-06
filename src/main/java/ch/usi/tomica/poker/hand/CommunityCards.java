package ch.usi.tomica.poker.hand;

/**
 * Class representing the collection of community cards on the table
 * @author atomic
 *
 */
public class CommunityCards extends CardCollection {
	public final static int OTHER = 0;
	public final static int SUIT3 = 1;
	public final static int SUIT4 = 2;
	public final static int RAINBOW = 3;
	public final static int STRAIGHT3 = 4;
	public final static int STRAIGHT4 = 5;
	public final static int SF3 = 6;
	public final static int TRIPLE = 7;
	public final static int PAIR = 8;
	public final static int TWOPAIR = 9;
	
	private final static String[] communityNames = {
		"other","suit3","suit4","rainbow", "straight3",
		"straight4","sf3", "triple","pair","twopair" 
	};
	
	public static String getCommunityStr(int type) {
		if (type < 0 || type > 9) return null;
		return communityNames[type];
	}
	
	public int evaluateBoard() {
		// TODO Implement logic to determine what is the state of the board
		return 0;
	}
	
	public CommunityCards(int vals[]) {
		initializeCardCollecton(vals);
	}
	
	public CommunityCards() {
		initializeCardCollecton();
	}
	
}
