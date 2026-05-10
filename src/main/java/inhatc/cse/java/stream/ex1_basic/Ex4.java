package inhatc.cse.java.stream.ex1_basic;

import java.util.HashSet;
import java.util.Set;

/**
 * equals/hashCode + HashSet
 * Course(code, title) 클래스를 만들고, 과목 코드(code)가 같으면 같은 과목으로 판단되도록 equals()와 hashCode()를 재정의하세요.
 *
 * 데이터
 * ("CS101", "Java")
 * ("CS101", "Java-dup")
 * ("CS102", "DB")
 * ("CS103", "Network")
 * ("CS102", "DB-dup")
 * 요구사항
 * HashSet 크기 출력
 * 코드 기준 오름차순 출력
 */
public class Ex4 {
    public static void main(String[] args) {
        Set<Course> courses = new HashSet<>();
        courses.add(new Course("CS101", "Java"));
        courses.add(new Course("CS101", "Java-dup"));
        courses.add(new Course("CS102", "DB"));
        courses.add(new Course("CS103", "Network"));
        courses.add(new Course("CS102", "DB-dup"));

        System.out.println("HashSet 크기: " + courses.size());
        courses.stream()
                .sorted((c1, c2) -> c1.getCode().compareTo(c2.getCode()) )
                .forEach(System.out::println);
    }
}

