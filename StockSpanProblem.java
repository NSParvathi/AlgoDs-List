package collections.list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The stock span problem is a financial problem where we have a series of n
 * daily price quotes for a stock and we need to calculate the span of stocks
 * price for all n days. The span Si of the stocks price on a given day i is
 * defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than or equal to
 * its price on the given day. For example, if an array of 7 days prices is
 * given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
 * corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
 * 
 * Solution: 
 * I followed the same approach as in Finding the Previous Closest Greater Element.
 * I'm looking for the current stock's previous closest highest price, then
 * number of consecutive days stock price = current index - previous greater element index 
 *
 * If no preceding greater element exists, the number of consecutive days equals index + 1. 
 *
 */
public class StockSpanProblem {

	public static int[] calculateSpan(int price[], int n) {
		// Your code here
		Deque<Integer> stack = new ArrayDeque<>();
		int[] res = new int[n];
		stack.push(0);
		res[0] =1;
		
		for (int i = 1; i < price.length; i++) {
			while (stack.isEmpty() == false && price[i] >= price[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty())
				res[i]= i+1;
			else
				res[i]= i-stack.peek();
			stack.push(i);

		}
		return res;
	}
	public static void main(String args[]) {
		int[] arr = {100,80,60,70,60,75,85};
		int[] res = calculateSpan(arr,arr.length);
		for(int x:res)
			System.out.print(x+" ");
	}

}
