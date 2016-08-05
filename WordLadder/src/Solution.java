import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Demon 2016.8.5
 * 
 *         Given two words (beginWord and endWord), and a dictionary's word
 *         list, find the length of shortest transformation sequence from
 *         beginWord to endWord, such that:
 * 
 *         Only one letter can be changed at a time Each intermediate word must
 *         exist in the word list For example,
 * 
 *         Given: beginWord = "hit" endWord = "cog" wordList =
 *         ["hot","dot","dog","lot","log"] As one shortest transformation is
 *         "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * 
 *         Note: Return 0 if there is no such transformation sequence. All words
 *         have the same length. All words contain only lowercase alphabetic
 *         characters.
 *
 */
public class Solution {

	public static void main(String[] args) {
		String begin = "hit";
		String end = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("log");
		wordList.add("lot");
		Solution solution = new Solution();
		System.out.println(solution.ladderLength(begin, end, wordList));
		System.out.println(solution.ladderLength2EndBFS(begin, end, wordList));
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		return ladderLengthBFS(beginWord, endWord, wordList);
	}

	// BFS 117ms
	public int ladderLengthBFS(String beginWord, String endWord,
			Set<String> wordList) {
		wordList.add(endWord);
		Queue<String> toVisit = new ArrayDeque<String>();
		Set<String> visited = new HashSet<String>();
		toVisit.offer(beginWord);
		visited.add(beginWord);
		int dist = 2;
		while (!toVisit.isEmpty()) {
			int size = toVisit.size();
			for (int i = 0; i < size; i++) {
				String wordToVisit = toVisit.poll();
				if (wordToVisit.equals(endWord))
					return dist;
				char wordToVisitChars[] = wordToVisit.toCharArray();
				for (int j = 0; j < wordToVisitChars.length; j++) {
					char letter = wordToVisitChars[j];
					for (char k = 'a'; k <= 'z'; k++) {
						wordToVisitChars[j] = k;
						String s = String.valueOf(wordToVisitChars);
						if (s.equals(endWord))
							return dist;
						if (wordList.contains(s) && !visited.contains(s)) {
							visited.add(s);
							toVisit.offer(s);
						}
					}
					wordToVisitChars[j] = letter;
				}
			}
			dist++;
		}
		return 0;
	}

	// 2 end BFS 34ms
	public int ladderLength2EndBFS(String beginWord, String endWord,
			Set<String> wordList) {
		HashSet<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		HashSet<String> visited = new HashSet<String>();
		int dist = 2;
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				HashSet<String> tmp = beginSet;
				beginSet = endSet;
				endSet = tmp;
			}
			HashSet<String> nextBeginSet = new HashSet<String>();
			for (String word : beginSet) {
				char[] wordToVisitChars = word.toCharArray();
				for (int i = 0; i < word.length(); i++) {
					char old = wordToVisitChars[i];
					for (char c = 'a'; c <= 'z'; c++) {
						wordToVisitChars[i] = c;
						String s = String.valueOf(wordToVisitChars);
						if (endSet.contains(s))
							return dist;
						if (!visited.contains(s) && wordList.contains(s)) {
							visited.add(s);
							nextBeginSet.add(s);
						}
					}
					wordToVisitChars[i] = old;
				}
			}
			beginSet = nextBeginSet;
			dist++;
		}
		return 0;
	}
}
