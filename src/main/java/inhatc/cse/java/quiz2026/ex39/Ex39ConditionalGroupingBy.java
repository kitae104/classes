package inhatc.cse.java.quiz2026.ex39;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * groupingBy + sorted 조합 - 그룹별 정렬
 */
public class Ex39ConditionalGroupingBy {
    
    static class Student {
        int id;
        String name;
        String gender;
        int score;
        
        public Student(int id, String name, String gender, int score) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.score = score;
        }
        
        public String getName() {
            return name;
        }
        
        public String getGender() {
            return gender;
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
            new Student(1001, "Kim", "F", 85),
            new Student(1002, "Lee", "M", 75),
            new Student(1003, "Park", "M", 90),
            new Student(1004, "Choi", "F", 88)
        );
        
        System.out.println("원본 학생 리스트:");
        students.forEach(System.out::println);
        
        // groupingBy()로 성별 분류하면서 각 그룹을 점수 내림차순으로 정렬
        Map<String, List<Student>> grouped = students.stream()
                                                      .collect(Collectors.groupingBy(Student::getGender,
                                                                                      Collectors.collectingAndThen(
                                                                                          Collectors.toList(),
                                                                                          list -> list.stream()
                                                                                                    .sorted(Comparator.comparingInt(Student::getScore).reversed())
                                                                                                    .collect(Collectors.toList()))));
        
        System.out.println("\n성별별 학생 (점수 내림차순):");
        grouped.forEach((gender, studentList) -> {
            System.out.println("[" + (gender.equals("M") ? "남" : "여") + "]");
            studentList.forEach(s -> System.out.println("  " + s));
        });
    }
}

