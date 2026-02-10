package inhatc.cse.java.chap12.ex2_collection.ex2_linkedlist;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<String>();
		
		myList.add("A");
		myList.add("B");
		myList.add("C");
		
		System.out.println(myList);
		myList.add(1, "D"); // insert 기능
		
		System.out.println(myList);
		
		myList.addFirst("O"); // 맨 앞에 추가
        myList.addLast("Z");  // 맨 뒤에 추가
		System.out.println(myList);
		System.out.println(myList.removeLast());
		
		System.out.println(myList);
    }
}
