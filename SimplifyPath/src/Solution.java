import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author Demon 2016.7.31
 * 
 *         Given an absolute path for a file (Unix-style), simplify it.
 * 
 *         For example, path = "/home/", => "/home" path = "/a/./b/../../c/", =>
 *         "/c".
 * 
 *         Corner Cases: Did you consider the case where path = "/../"? In this
 *         case, you should return "/".
 * 
 *         Another corner case is the path might contain multiple slashes '/'
 *         together, such as "/home//foo/". In this case, you should ignore
 *         redundant slashes and return "/home/foo".
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.simplifyPath("/home/"));
		System.out.println(solution.simplifyPath("/a/./b/../../c/"));
		System.out.println(solution.simplifyPath("/../"));
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		Set<String> skip = new HashSet<String>(Arrays.asList("..", ".", ""));
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(dir))
				stack.push(dir);
		}
		StringBuilder sb = new StringBuilder();
		for (String s : stack)
			sb.append("/" + s);
		return sb.toString().isEmpty() ? "/" : sb.toString();
	}

}
