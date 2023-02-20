package collections.list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Here we will store the previous greater element in Stack. 
 * There are 2 possibilities
 * 1. greater than the previous element
 * if we encounter a greater element we have to pop all the elements which are smaller than that
 * and then push this one because for the next element this will be the nearest greater element, even there can be so many greater elements but this is 
 * nearest greater element until unless next element is greater that that. 
 * 
 * 2. Smaller or equal to the previous element 
 * if  you encounter a smaller element which is less than the previous element we will push it and nearest greater is the previous element only 
 * and the reason we need to push this element is that for the next element it might be the nearest greater means next element can be smaller that this. 
 * 
 * if stack is empty means there is no previous element which is greatest so print -1
 * 
 * if it is bigger than that u have to pop all the elements which are smaller than the current
 * element because its like barrier for the next element means it must be nearest greater for the next element until it is greater. if is smaller means
 * all the element which are popped earlier are already smaller than the element on the top and those are far also, so this is the the nearest greater
 * element.
 * 
 * @author Sravani
 *
 */
public class PreviousGreaterElement {

	public static void prevGreaterEle(int arr[]) {

		Deque<Integer> stack = new ArrayDeque<>();

		stack.push(arr[0]);
		System.out.println(-1);
		for (int i = 1; i < arr.length; i++) {
			while (stack.isEmpty() == false && arr[i] > stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty())
				System.out.println("-1");
			else
				System.out.println(stack.peek());
			stack.push(arr[i]);

		}

	}
	
	public static void main(String args[]) {
		int[] arr = {15,10,18,12,4,6,2,8};
		prevGreaterEle(arr);
	}
}
