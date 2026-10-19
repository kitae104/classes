package inhatc.cse.java.stream.days;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 학생을 점수에 따라 우수(80점 이상), 보통(60~79점), 미흡(60점 미만) 세 그룹으로 분류하는 프로그램을 작성하세요.
 * 요구사항
 * 1. record를 이용해 Student 자료형을 정의하세요.
 * 2. stream()과 Collectors.groupingBy()를 사용하세요.
 * 3. 람다 표현식으로 학생의 점수에 따른 그룹을 결정하세요.
 * 4. 그룹별 학생 수를 Collectors.counting()으로 계산하세요.
 * 5. 일반 for, while 반복문은 사용하지 마세요.
 */
public class Day3 {
    record Student(String name, int score) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 95),
                new Student("Lee", 72),
                new Student("Park", 88),
                new Student("Choi", 55),
                new Student("Jung", 67),
                new Student("Han", 92),
                new Student("Kang", 48)
        );

        // TODO 1. 학생을 성적에 따라 그룹화
        Map<String, List<Student>> groups = students.stream()
                .collect(Collectors.groupingBy(student -> {
                    if(student.score() >= 80) return "우수";
                    else if(student.score() >= 60) return "보통";
                    else return "미흡";
                }));

        System.out.println("그룹화 결과: " + groups);
        groups.keySet().forEach(key -> {
            System.out.print(key + " : [ " + groups.get(key).stream()
                    .map(Student::name)
                    .collect(Collectors.joining(", ")));
            System.out.println(" ]");
        });

        // TODO 2. 그룹별 학생 수 계산
        Map<String, Long> groupCounts = students.stream()
                .collect(Collectors.groupingBy(student -> {
                    if(student.score() >= 80) return "우수";
                    else if(student.score() >= 60) return "보통";
                    else return "미흡";
                }, Collectors.counting()));

        System.out.println("그룹별 학생 수: " + groupCounts);
        groupCounts.keySet().forEach(key -> {
            System.out.println(key + " : " + groupCounts.get(key) + "명");
        });

        Map<String, Double> groupAverages = students.stream()
                .collect(Collectors.groupingBy(student -> {
                    if(student.score() >= 80) return "우수";
                    else if(student.score() >= 60) return "보통";
                    else return "미흡";
                }, Collectors.averagingInt(Student::score)));

        System.out.println("그룹별 평균 점수: " + groupAverages);
        groupAverages.keySet().forEach(key -> {
            System.out.printf("%s : %.2f%n", key, groupAverages.get(key));
        });
    }
}
