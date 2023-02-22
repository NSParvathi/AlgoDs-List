package collections.codeforces;
/**
 * Problem Statement : https://codeforces.com/group/c3FDl9EUi9/contest/263096/problem/E
 * CF Solution Link : https://codeforces.com/group/c3FDl9EUi9/contest/263096/submission/194557323
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 
 * @author Sravani E. Queue time limit per test1 second memory limit per test256
 *         megabytes inputstandard input outputstandard output You have an empty
 *         queue of integers, and q queries in the following format:
 * 
 *         push x : where (1≤x≤109) add x in the end of the queue.
 *         pop : remove the first element in the queue. 
 *         front : print the first element in the queue. 
 *         back : print the last element in the queue. 
 *         It's guaranteed that in the last 3 types of the query, the queue is not
 *         empty
 */
public class QueueOperation {
static Deque<Integer> q = new ArrayDeque<>();
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			if(query.equalsIgnoreCase("push"))
				q.offerLast(Integer.parseInt(st.nextToken()));
			else if(query.equalsIgnoreCase("pop"))
				q.pollFirst();
			else if(query.equalsIgnoreCase("front"))
				out.println(q.peekFirst());
			else if(query.equalsIgnoreCase("back"))
				out.println(q.peekLast());
		}
		out.flush();
	}
}
