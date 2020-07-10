package collection;

import java.util.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("test");
		list.addFirst("zz");
		list.addLast("zz");
		
//		list.removeIf(n -> n.length()==2);
		list.poll();
		
		System.out.println(list);
	}

}
