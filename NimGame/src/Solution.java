
/**
 * 
 * @author Demon 2016.7.22
 *
 *         You are playing the following Nim Game with your friend: There is a
 *         heap of stones on the table, each time one of you take turns to
 *         remove 1 to 3 stones. The one who removes the last stone will be the
 *         winner. You will take the first turn to remove the stones.
 * 
 *         Both of you are very clever and have optimal strategies for the game.
 *         Write a function to determine whether you can win the game given the
 *         number of stones in the heap.
 * 
 *         For example, if there are 4 stones in the heap, then you will never
 *         win the game: no matter 1, 2, or 3 stones you remove, the last stone
 *         will always be removed by your friend.
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	// If n = 4, i will lose.
	// If n = 5, 6, 7, i can remove 1, 2, 3 stones and it is his turn and now n = 4, according to first line, he will lose.
	// If n = 8, he can control the situation and the case is n = 4 , my turn, according to first line, i will lose.
	// ...
	// So if n % 4 == 0, i will lose.
	public boolean canWinNim(int n) {
		if (n <= 0)
			return false;
		return n % 4 != 0;
	}
}
