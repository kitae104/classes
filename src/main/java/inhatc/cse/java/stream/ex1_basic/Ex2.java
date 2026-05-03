package inhatc.cse.java.stream.ex1_basic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream map/joining
 *
 * 사람 목록에서 성인(20세 이상)의 이름만 추출하여 대문자로 바꾸고, 사전순 정렬 후 `", "`로 이어 붙이세요.
 *
 * ## 데이터
 * - ("alice", 19)
 * - ("bob", 22)
 * - ("chris", 27)
 * - ("david", 17)
 */

public class Ex2 {
    // 클래스랑 비교하기
    record Person(String name, int age) {}

    public static void main(String[] args) {
        String str = List.of(
                        new Person("alice", 19),
                        new Person("bob", 22),
                        new Person("chris", 27),
                        new Person("david", 17))
                .stream()
                .filter(person -> person.age() >= 20) // 성인 필터링
                .map(person -> person.name().toUpperCase()) // 이름 대문자로 변
                .sorted((p1, p2) -> p1.compareTo(p2))
                .collect(Collectors.joining(", "));

        System.out.println(str);


    }
}
