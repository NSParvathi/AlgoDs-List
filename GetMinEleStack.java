package collections.list;
/**
 * Problem statement : You are given an array A of size N. You need to first push the elements of the array into a stack and then print minimum
 *  in the stack at each pop until stack becomes empty.
 */
import java.util.Iterator;
import java.util.Stack;

public class GetMinEleStack {
 static Stack<Integer> auxStack = new Stack<>();
	
	// Function to push all the elements into the stack. and constructing aux stack which contains min element
	public static Stack<Integer> _push(int arr[], int n) {
	
		Stack<Integer> stack = new Stack<>();
		
		for (int x : arr) {
			stack.push(x);
			if(auxStack.isEmpty())
				auxStack.push(x);
			else
			{
				int y=  auxStack.peek();
				if(x < y)
					auxStack.push(x);
				else
					auxStack.push(y);
			}

		}
		return stack;
	}

	// Function to print minimum value in stack each time while popping.
	/**  Here I store the minimum element always in the min variable, and we are returning that value whenever we call pop() until you remove that element from the stack.
		If you removed the minimum element from the stack, you could use the getMin method to find the lowest value among the next elements and continue.
		If the elements are sorted, T.C. is O(n2).
		Auxiliary Space: O(1) 
	 */
	static void _getMinAtPop(Stack<Integer> s) {
		// your code here
		int min =0;
		if(s.isEmpty() == false)
		min = getMin(s);
		while(s.isEmpty() == false) {
			System.out.println(min);
			if(min == s.pop())
			{
				if(s.isEmpty() == false)
				min = getMin(s);
			}
		}
		

	}

	static int getMin(Stack<Integer> stack) {
		Iterator<Integer> it = stack.iterator();
		int min = it.next();
		while (it.hasNext()) {
			int x = it.next();
			if (x < min)
				min = x;
		}
		return min;
	}
	
	/**
	 * The most efficient method for determining the minimum value in O(n) and aux space O(n).
	 * Here we use one aux stack, which stores the always min value corresponding to the elements in the actual stack.
	 * While putting the actual elements in the stack, I'm building the aux stack with a stored minimum value corresponding to the actual stack elements.
	 * @param args
	 */
	
	static void _getMinAtPop_eff(Stack<Integer> s) {
		if(s.isEmpty() == false) {
			System.out.println(auxStack.pop());
			s.pop();
			
		}
	}
	
	
	public static void main(String args[]) {
		int[] arr = new int[] {3,2,1,4,5};
		Stack<Integer> stack = _push(arr,arr.length);
		_getMinAtPop_eff(stack);
		_getMinAtPop_eff(stack);
		
		_getMinAtPop_eff(stack);
		_getMinAtPop_eff(stack);
		_getMinAtPop_eff(stack);
		_getMinAtPop_eff(stack);
		
		
	}

}
