package other;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Poker
{

  /*
   * Given a set of 5 playing card identifiers such as 2H, 7C, QS, 10D, 2D;
   * determine if this hand is better than some other hand, according to the rules of poker.
   *
   * Hands will be a string with 5 cards comma separated,
   * each card will have 1-2 digits or JQKA and a suit indicator C,D,S,H (i.e. 10C, KH)
   *
   * Possible Hand Types Below:
   *   Straight flush
   *   Four of a kind
   *   Full house
   *   Flush
   *   Straight
   *   Three of a kind
   *   Two pair
   *   One pair
   *
   * The goal of this is to compare between the hand types.
   * Comparing 2 of the same type (i.e. 2 straights) to determine a winner is outside the scope
   * and will not be tested.
   *
   * Implement PokerHand.isGreaterThan(...) method and return whether or not the first hand wins over the second hand.
   */

   static class PokerHand {

      private String handAsString;

      public static final int StraightFlush = 9;
      
      public static final int FourofaKind = 8;  
    
      public static final int Fullhouse = 7;
      
      public static final int Flush = 6;
    
      public static final int Straight = 5;
    
      public static final int Threeofakind = 4;
    
      public static final int TwoPair = 3;
      
      public static final int OnePair = 2;

      public static final int Zilch = 1;
      
      
      public PokerHand(String hand) {
         handAsString = hand;
      }

      public Boolean isGreaterThan(PokerHand hand2) {
         // This is where you'll implement the poker hand comparison logic
//    	  System.out.println(hand2.handAsString+"-----"+handTypes(hand2.handAsString));
//    	  System.out.println(handAsString+"-----"+handTypes(handAsString));
    	 return handTypes(handAsString) > handTypes(hand2.handAsString);
      }

		static int handTypes(String s) {
			int[] nums = new int[5];
			Set<Character> set = new HashSet<>();
			String[] ss = s.split(",");

			for (int i = 0; i < ss.length; i++) {

				char c0 = ss[i].charAt(0);
				int n = 0;

				if (ss[i].length() > 2) {
					nums[i] = 10 - 2;
					set.add(ss[i].charAt(2));
					continue;
				}
				if (c0 == 'J') {
					n = 11;
				} else if (c0 == 'Q') {
					n = 12;
				} else if (c0 == 'K') {
					n = 13;
				} else if (c0 == 'A') {
					n = 14;
				} else {
					n = c0 - '0';
				}
				nums[i] = n - 2;
				set.add(ss[i].charAt(1));
			}
			Arrays.sort(nums);
			// System.out.println(Arrays.toString(nums));

			int[] numbers = new int[13];

			Arrays.fill(numbers, 0);

			for (int i = 0; i < nums.length; i++) {
				numbers[nums[i]]++;
			}

			// System.out.println(Arrays.toString(numbers)+"====[][]");

			List<Integer> nn = new ArrayList<Integer>();

			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] != 0) {
					nn.add(numbers[i]);
				}
			}

			if (nn.size() == 2) {
				if (nn.contains(4))
					return FourofaKind;
				else
					return Fullhouse;
			}

			else if (nn.size() == 3) {
				if (nn.contains(3))
					return Threeofakind;
				else
					return TwoPair;
			}

			else if (nn.size() == 4) {
				return OnePair;
			}

			else if (nn.size() == 5) {
				int aa = 0;
				for (int i = 1; i < numbers.length; i++) {
					if (numbers[i - 1] == 1 && numbers[i] == 1)
						aa++;
				}
				if (aa == 4 && set.size() == 1) {
					return StraightFlush;
				} else if (aa == 4 && set.size() > 1) {
					return Straight;
				} else if (set.size() == 1) {
					return Flush;
				} else {
					return Zilch;
				}
			}
			return 0;
		}

		@Override
		public String toString() {
			return handAsString;
		}
	}

   public static void testHand1IsGreaterThanHand2(String hand1AsString,  String hand2AsString, Boolean expectedResult) {
      PokerHand hand1 = new PokerHand(hand1AsString);
      PokerHand hand2 = new PokerHand(hand2AsString);
      System.out.println("Hand1[" + hand1 + "] > Hand2[" + hand2 + "] \t-- " +  "expected: " + expectedResult + ", actual: " + hand1.isGreaterThan(hand2));
   }

	public static void main(String[] args) {
		testHand1IsGreaterThanHand2("8C,9C,10C,JC,QC", // straight flush
				"6S,7H,8D,9H,10D", true);

		testHand1IsGreaterThanHand2("4H,4D,4C,4S,JS", // four of a kind
				"6C,6S,KH,AS,AD", true);

		testHand1IsGreaterThanHand2("6C,6D,6H,9C,KD", "5C,3C,10C,KC,7C", // flush
				false);

		testHand1IsGreaterThanHand2("4H,4D,4C,KC,KD", // full house
				"9D,6S,KH,AS,AD", true);

		testHand1IsGreaterThanHand2("6C,6D,6H,9C,KD", "2C,3C,4S,5S,6S", // straight
				false);

		testHand1IsGreaterThanHand2("7C,7D,7S,3H,4D", // three of a kind
				"9S,6S,10D,AS,AD", true);

		testHand1IsGreaterThanHand2("2S,2D,JH,7S,AC", "8C,8H,10S,KH,KS", // two
																			// pair
				false);

		testHand1IsGreaterThanHand2("AC,AH,3C,QH,10C", // one pair
				"3S,2D,KH,JS,AD", true);
	}
}