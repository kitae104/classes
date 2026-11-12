package inhatc.cse.java.stream.days;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Day6 {

    record Student(String name, String major, int score) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", "Computer", 95),
                new Student("Lee", "Electronic", 88),
                new Student("Park", "Computer", 72),
                new Student("Choi", "Computer", 91),
                new Student("Jung", "Mechanical", 85),
                new Student("Han", "Computer", 67),
                new Student("Kang", "Electronic", 93)
        );

        // filter()를 이용하여 전공이 Computer인 학생만 선택하세요.
        List<Student> computerMajor = students.stream()
                .filter(s -> s.major.equals("Computer"))
                .toList();
        System.out.println("Computer 전공 학생: " + computerMajor);

        // 점수가 80점 이상인 학생만 추출하세요.
        List<Student> over80Student = students.stream()
                .filter(s -> s.score >= 80)
                .toList();
        System.out.println("점수가 80점 이상인 학생: " + over80Student);

        // max()와 Comparator.comparingInt()를 이용하여 최고 점수 학생을 찾으세요.
        Optional<Student> maxStudent = students.stream()
                .max(Comparator.comparingInt(Student::score));

        // 검색 결과를 출력하세요.
        maxStudent.ifPresentOrElse(
                s -> System.out.println("최고 점수 학생: " + s),
                () -> System.out.println("학생이 없습니다.")
        );

        if(maxStudent.isPresent()) {
            Student student = maxStudent.get();
            System.out.println("==== 검색 결과 ====");
            System.out.println("학생 이름: " + student.name());
            System.out.println("전공: " + student.major());
            System.out.println("점수: " + student.score());

        }
    }
}