package inhatc.cse.java.quiz2026.ex34;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * filter + sorted + limit 복합 처리
 */
public class Ex34ComplexObjectStream {
    
    static class Student {
        int id;
        String name;
        int score;
        
        public Student(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }
        
        public String getName() {
            return name;
        }
        
        public int getScore() {
            return score;
        }
        
        @Override
        public String toString() {
            return name + " (" + score + "점)";
        }
    }
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1001, "Kim", 85),
            new Student(1002, "Lee", 75),
            new Student(1003, "Park", 90),
            new Student(1004, "Choi", 88),
            new Student(1005, "Jung", 92),
            new Student(1006, "Kang", 70)
        );
        
        System.out.println("원본 학생 리스트:");
        students.forEach(System.out::println);
        
        // filter(80점 이상) -> sorted(이름) -> limit(3)
        List<Student> topThree = students.stream()
                                          .filter(s -> s.getScore() >= 80)  // 80점 이상만
                                          .sorted(Comparator.comparing(Student::getName))  // 이름 오름차순
                                          .limit(3)  // 상위 3명
                                          .collect(Collectors.toList());
        
        System.out.println("\n80점 이상, 이름 정렬, 상위 3명:");
        topThree.forEach(System.out::println);
    }
}

