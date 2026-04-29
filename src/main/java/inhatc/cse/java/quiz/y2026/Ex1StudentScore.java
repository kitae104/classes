package inhatc.cse.java.quiz.y2026;

import java.util.*;
import java.util.stream.Collectors;

public class Ex1StudentScore {

    enum Grade { A, B, C, D, F }

    static class Student {
        private final int id;
        private final String name;
        private final int score;
        private final Grade grade;

        Student(int id, String name, int score, Grade grade) {
            this.id = id;
            this.name = name;
            this.score = score;
            this.grade = grade;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public Grade getGrade() { return grade; }

        @Override
        public String toString() {
            return String.format("Student{id=%d, name='%s', score=%d, grade=%s}", id, name, score, grade);
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1001, "김철수", 90, Grade.A),
                new Student(1002, "이영희", 75, Grade.C),
                new Student(1003, "박민수", 85, Grade.B),
                new Student(1004, "최지우", 95, Grade.A),
                new Student(1002, "이영희", 75, Grade.C)
        );

        System.out.println("==== 원본 리스트 ====");
        students.forEach(System.out::println);

        // 1) 점수가 80점 이상인 학생만 출력
        System.out.println("\n==== 1) 점수 80점 이상 ====");
        students.stream()
                .filter(s -> s.getScore() >= 80)
                .forEach(System.out::println);

        // 2) 이름 기준 오름차순 정렬
        System.out.println("\n==== 2) 이름 기준 오름차순 ====");
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);

        // 3) 점수 기준 내림차순 정렬 (Comparator 사용)
        System.out.println("\n==== 3) 점수 기준 내림차순 ====");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .forEach(System.out::println);

        // 4) 학점별 학생 수
        System.out.println("\n==== 4) 학점별 학생 수 ====");
        Map<Grade, Long> byGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        for (Grade g : Grade.values()) {
            System.out.printf("%s : %d%n", g, byGrade.getOrDefault(g, 0L));
        }

        // 5) 중복 학생 제거 (학번 기준) - 첫 등장 유지
        System.out.println("\n==== 5) 중복 학생 제거 (학번 기준, 첫 등장 유지) ====");
        Map<Integer, Student> uniqueById = new LinkedHashMap<>();
        for (Student s : students) {
            uniqueById.putIfAbsent(s.getId(), s);
        }
        uniqueById.values().forEach(System.out::println);

        // 6) 점수가 가장 높은 학생 1명
        System.out.println("\n==== 6) 최고 점수 학생 ====");
        students.stream()
                .max(Comparator.comparingInt(Student::getScore))
                .ifPresent(System.out::println);
    }
}

