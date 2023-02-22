package collections.codeforces;
/**
 * Problem Link :https://codeforces.com/group/c3FDl9EUi9/contest/263096/problem/D
 * Solution Link : https://codeforces.com/group/c3FDl9EUi9/contest/263096/submission/194556991
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class StackOperations {
	
	static Deque<Integer> s = new ArrayDeque<>();
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			if(query.equalsIgnoreCase("push"))
				s.push(Integer.parseInt(st.nextToken()));
			else if(query.equalsIgnoreCase("pop"))
				s.pop();
			else if(query.equalsIgnoreCase("top"))
				out.println(s.peek());
		}
		out.flush();
	}
	
	
}
