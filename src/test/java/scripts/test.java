package scripts;

import java.util.LinkedList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> ll = new LinkedList<String>();
		ll.add("Himanshu");
		ll.add("Jain");
		ll.add("tester 123");
		
		String str = ll.toString();
		System.out.println(str);
		ll.add(str);
		
		
		for (String x:ll) {
			System.out.println(x);
		}
	}

}
