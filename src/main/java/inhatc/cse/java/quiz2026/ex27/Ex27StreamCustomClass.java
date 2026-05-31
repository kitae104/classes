package inhatc.cse.java.quiz2026.ex27;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * Stream with custom class - 객체의 속성으로 필터링
 */
public class Ex27StreamCustomClass {
    
    // 간단한 Student 클래스
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
    }
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1001, "Kim", 85),
            new Student(1002, "Lee", 65),
            new Student(1003, "Park", 90),
            new Student(1004, "Choi", 75)
        );
        
        System.out.println("원본 학생 리스트:");
        students.forEach(s -> System.out.println(s.name + " : " + s.score + "점"));
        
        // filter()로 70점 이상 선택, map()으로 이름만 뽑기
        List<String> passedStudents = students.stream()
                                               .filter(s -> s.getScore() >= 70)  // 70점 이상
                                               .map(Student::getName)  // 이름 추출
                                               .collect(Collectors.toList());
        
        System.out.println("\n70점 이상인 학생:");
        passedStudents.forEach(System.out::println);
    }
}

