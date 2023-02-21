package collections.list;
/**
 * Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).
 */
import java.util.ArrayDeque;
import java.util.Deque;
//Parenthesis checker using Stack
/*
 * I am pushing the parenthesis into the stack whenever I encounter an opening parenthesis.
 * When I encounter closing parenthesis, I pop the opening parenthesis from the stack and compare it with the closing. If both are pairs, move on to the next one.
 * Otherwise, it will return false.
 * If the stack is empty (meaning there aren't enough opening parenthesis), return false while popping from it.
 * If you reach the end of the string, we must check whether the stack is empty; if it is, the parenthesis is balanced, and we return true.
 * If is not empty, there is not sufficient closing parenthesis, so return false.
 */
public class ParenthesisChecker {

	
	static boolean ispar(String x)
    {
        // add your code here
		Deque<Character> stack = new ArrayDeque<>();
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i) == '{' || x.charAt(i) == '[' || x.charAt(i) == '(')
				stack.push(x.charAt(i));
			else {
				if(stack.isEmpty())
					return false;
				if(!matcher(x.charAt(i),stack.poll()))
					return false;
			
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
    }
	static boolean matcher(char c1,char c2) {
		if(c1 == '}' && c2 == '{')
			return true;
		if(c1==']' && c2 == '[')
			return true;
		if(c1==')' && c2 == '(')
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println(ispar("{[()]}"));
		System.out.println(ispar("{[()]}]"));
		System.out.println(ispar("("));
	}
}
