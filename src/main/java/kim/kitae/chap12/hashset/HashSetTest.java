package kim.kitae.chap12.hashset;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTest {
    public static void main(String[] args) {

		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add(new String("임정순"));
		hashSet.add(new String("박현정"));
		hashSet.add(new String("홍연의"));
		hashSet.add(new String("강감찬"));
		hashSet.add(new String("강감찬"));
		hashSet.add(new String("손흥민"));
		
		System.out.println(hashSet);

        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add(new String("임정순"));
		treeSet.add(new String("박현정"));
		treeSet.add(new String("홍연의"));
		treeSet.add(new String("강감찬"));
		treeSet.add(new String("강감찬"));
		treeSet.add(new String("손흥민"));

		
		System.out.println(treeSet);
	}
}
