package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class JosephusPbm {
	
	public static LinkedList<Integer> josephusPbm(LinkedList<Integer> list,int k) {
		Iterator<Integer> it  = list.iterator();;
		while (list.size() > 1) {
			
			int count = 1;
			while (count <= k) {
				while (it.hasNext() && count <= k) {
					it.next();
					count++;
				}

				if (count <= k) {
					it = list.iterator();
					it.next();
					count++;
				}

			}
			it.remove();
		}

		return list;

	}
	

	public static void main(String[] args) {

		int k = 3;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(josephusPbm(list,k));

	}

}
