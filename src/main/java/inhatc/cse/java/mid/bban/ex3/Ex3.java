package inhatc.cse.java.mid.bban.ex3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
학생 정보가 아래와 같을 때 해당 기능을 구현하세요.
(1001, "김철수", 90, Grade.A)
(1002, "이영희", 75, Grade.C)
(1003, "박민수", 85, Grade.B)
(1004, "최지우", 95, Grade.A)
(1002, "이영희", 75, Grade.C)

1. 점수가 80점 이상인 학생만 출력하시오.
2. 이름 기준 오름차순 정렬 결과를 출력하시오.
3. 점수 기준 내림차순 정렬 결과를 출력하시오.
4. 중복 학생을 제거한 결과를 출력하시오.
5. 점수가 가장 높은 학생 1명을 출력하시오.

 */
public class Ex3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1001, "김철수", 90, Grade.A),
                new Student(1002, "이영희", 75, Grade.C),
                new Student(1003, "박민수", 85, Grade.B),
                new Student(1004, "최지우", 95, Grade.A),
                new Student(1002, "이영희", 75, Grade.C) // 중복
        );

        // 1. 점수 80 이상
        System.out.println("=== 1) 80점 이상 ===");
        students.stream()
                .filter(s -> s.getScore() >= 80)
                .forEach(System.out::println);

        // 2. 이름 오름차순 정렬
        System.out.println("\n=== 2) 이름 오름차순 ===");
        students.stream()
                .sorted((x1, x2) -> x1.getName().compareTo(x2.getName()))
                .forEach(System.out::println);

        // 3. 점수 내림차순 정렬
        System.out.println("\n=== 3) 점수 내림차순 ===");
        students.stream()
                .sorted((s1, s2) -> s2.getScore() - s1.getScore())
                .forEach(System.out::println);

        // 4. 중복 제거
        System.out.println("\n=== 4) 중복 제거 ===");
        students.stream()
                .distinct()
                .forEach(System.out::println);

        // 5. 최고 점수 학생
        System.out.println("\n=== 5) 최고 점수 학생 ===");
        students.stream()
                .sorted((s1, s2) -> s2.getScore() - s1.getScore())
                .limit(1)
                .forEach(System.out::println);

    }
}
