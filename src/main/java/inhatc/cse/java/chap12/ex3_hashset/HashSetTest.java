package inhatc.cse.java.chap12.ex3_hashset;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Collections;

public class HashSetTest {
    public static void main(String[] args) {

		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("임정순");
		hashSet.add("박현정");
		hashSet.add("홍연의");
		hashSet.add("강감찬");
		hashSet.add("강감찬");
		hashSet.add("손흥민");

		System.out.println(hashSet);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("임정순");
		treeSet.add("박현정");
		treeSet.add("홍연의");
		treeSet.add("강감찬");
		treeSet.add("강감찬");
		treeSet.add("손흥민");

		
		System.out.println(treeSet);

		System.out.println("역순 : " + treeSet.descendingSet());

		// Collections.reverseOrder()를 이용해 역순 비교자를 가진 새로운 TreeSet을 생성한 뒤 복사해서 출력할 수도 있습니다.
		TreeSet<String> reverseTree = new TreeSet<>(Collections.reverseOrder());
		reverseTree.addAll(treeSet);
		System.out.println("역순 (new TreeSet with reverseOrder): " + reverseTree);
	}
}
