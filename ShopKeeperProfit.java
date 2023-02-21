package collections.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Problem Statement : Ram makes a plan for the new year. He decides to sell the
 * products and writes down the price for N days. The prices are denoted by an
 * array V[] of N elements. Looking at the sequence he decides that for the ith
 * product, he is going to get a profit that equals to (Vj - Vi), where j is the
 * lowest index just greater than i and Vj >= Vi. If there is no such j, then
 * his profit will be equal to Vi. Find the total profit of Ram. 
 *
 */
public class ShopKeeperProfit {

	/* 
	 * According to problem statment we have to find next closest greater element vj for element the vi and  j>i
	 * Profit = vj-vi if exits.if not profit = v1
      
	 * This is analogous to locating the next largest element in an array.
 	 * To find the next greatest element, begin at the end of the array and proceed as follows.I am using Stack so that we can get the nearest element.
	 * 1. If the element's value is less than the peak of the stack, profit = peak - current element, and then push the current element into the stack.
	 * 2. If the current element is greater than peek, pop all the elements smaller than it until you find the greater element or reach the end of the stack.
	      Profit = greater element - curr element, if you find the greater element.
		  If you cannot locate it, profit = currency element,
          The current element is then pushed into the stack.
	 */
	public static int profit(ArrayList<Integer> V) {
		// Your code here
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int alSize = V.size();
		stack.push(V.get(alSize-1));
		int profit=V.get(alSize-1);
		for(int i = alSize-2; i>=0; i--) {
			while(stack.isEmpty() == false && V.get(i) > stack.peek() ) {
				stack.pop();
			}
			if(stack.isEmpty())
				profit+=V.get(i);
			else
				profit+=(stack.peek()-V.get(i));
			stack.push(V.get(i));
		}
		
		return profit;
			
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<N;i++)
			list.add(Integer.parseInt(st.nextToken()));
		
		System.out.println(profit(list));
	}
}
