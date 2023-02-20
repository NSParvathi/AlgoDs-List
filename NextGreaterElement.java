package collections.list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem Statement : Given an array, print the Next Greater Element(NGE) for every element.
 * 
 * Same like previous greater elements
 * The only difference is that we need to traverse from the end of array as we need to find next closest greater element.
 *  while traversing we will compare the current element with the elements which are present in the right side of the element.
 */
public class NextGreaterElement {
	
	public static int[]  nextGreaterEle(int arr[]) {

		Deque<Integer> stack = new ArrayDeque<>();
		int n = arr.length;
		int[] res = new int[n];
		stack.push(arr[n-1]);
		res[n-1] = -1;
		System.out.println(-1);
		for (int i = n-2; i >=0; i--) {
			while (stack.isEmpty() == false && arr[i] > stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty())
				res[i] = -1;
			else
				res[i] = stack.peek();
			stack.push(arr[i]);

		}
		return res;

	}
	
	public static void main(String args[]) {
		int[] arr = {15,10,18,12,4,6,2,8};
		int[] res = nextGreaterEle(arr);
		for(int x : res)
			System.out.print(x+" ");
		
		System.out.println();
	}
}
