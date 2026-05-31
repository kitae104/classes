package inhatc.cse.java.quiz2026.ex45;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * 여러 기준 정렬 - thenComparing 사용
 */
public class Ex45MultiSorting {
    
    static class Student {
        String name;
        int score;
        
        public Student(String name, int score) {
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
            return name + " : " + score + "점";
        }
    }
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Kim", 90),
            new Student("Lee", 85),
            new Student("Park", 90),
            new Student("Choi", 85)
        );
        
        System.out.println("원본 학생 리스트:");
        students.forEach(System.out::println);
        
        // Comparator.comparing().reversed() + thenComparing()으로 다중 정렬
        List<Student> sorted = students.stream()
                                        .sorted(Comparator.comparingInt(Student::getScore).reversed()  // 점수 내림차순
                                                          .thenComparing(Student::getName))  // 이름 오름차순
                                        .collect(Collectors.toList());
        
        System.out.println("\n점수 내림차순, 동점 이름 오름차순:");
        sorted.forEach(System.out::println);
    }
}

