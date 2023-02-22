package collections.codeforces;

/**
 * F. Deque
 * You have an empty deque dq of integers, and q queries in the following format:
 *
 * push_back  x : where (1≤x≤109)  add x at the end of the deque.
 * push_front  x : where (1≤x≤109) add x at the begin of the deque.
 * pop_front : remove the first element in the deque.
 * pop_back : remove the last element in the deque.
 * front : print the first element in the deque.
 * back : print the last element in the deque.
 * print x : where (1≤x≤|dq|)
 * print the element in index x  of the deque.
 * It's guaranteed that in the last 5 types of the query, the deque is not empty
 * 
 * CF Solution Link : https://codeforces.com/group/c3FDl9EUi9/contest/263096/submission/194558755
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * Here, i used LinkedList for implementing Deque instead of Deque interface and ArrayDeque Class.
 * The reason is that the program statement has a requirement to print an index element. ArrayDeque doesn't have the get(inedx) method as it doesn't implement the List interface.
 * List interface has get(index) method which is implemented by LinkedList so i used LinkedList.
 * 
 * @author Sravani
 *
 */
public class DequeOperation {

	static LinkedList<Integer> deque = new LinkedList<>();

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			if (query.equalsIgnoreCase("push_back"))
				deque.offerLast(Integer.parseInt(st.nextToken()));
			else if (query.equalsIgnoreCase("push_front"))
				deque.offerFirst(Integer.parseInt(st.nextToken()));
			else if (query.equalsIgnoreCase("pop_front"))
				deque.pollFirst();
			else if (query.equalsIgnoreCase("pop_back"))
				deque.pollLast();
			else if (query.equalsIgnoreCase("front"))
				out.println(deque.peekFirst());
			else if (query.equalsIgnoreCase("back"))
				out.println(deque.peekLast());
			else if (query.equalsIgnoreCase("print"))
				out.println(deque.get(Integer.parseInt(st.nextToken())-1));
		}
		out.flush();
	}
}
