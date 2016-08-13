import java.util.HashMap;

/**
 * 
 * @author Demon 2016.8.13
 * 
 *         Given  an  arbitrary  ransom  note  string  and  another  string
 *          containing  letters from  all  the  magazines,  write  a  function
 *          that  will  return  true  if  the  ransom   note  can  be
 *          constructed  from  the  magazines ;  otherwise,  it  will  return
 *          false.   
 * 
 *         Each  letter  in  the  magazine  string  can  only  be  used  once 
 *         in  your  ransom  note.
 * 
 *         Note: You may assume that both strings contain only lowercase
 *         letters.
 * 
 *         canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 *         canConstruct("aa", "aab") -> true
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canConstruct("a", "b"));
		System.out.println(solution.canConstruct("aa", "ab"));
		System.out.println(solution.canConstruct("aa", "aab"));
		System.out.println(solution.canConstruct("fffbfg",
				"effjfggbffjdgbjjhhdegh"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length())
			return false;
		if (magazine.isEmpty() && ransomNote.isEmpty())
			return true;
		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
		for (Character c : magazine.toCharArray())
			magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
		for (Character c : ransomNote.toCharArray()) {
			if (!magazineMap.containsKey(c))
				return false;
			else if (magazineMap.get(c) <= 0)
				return false;
			else
				magazineMap.replace(c, magazineMap.get(c) - 1);
		}
		return true;

	}
}
