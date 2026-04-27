package inhatc.cse.java.quiz.b;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ex10Answer {

    public static void main(String[] args) {
        List<Integer> ids = List.of(3, 7, 3, 2, 9, 7, 1, 9, 9, 4);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = ids.stream()
                .filter(id -> !seen.add(id))
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(duplicates);
    }
}
