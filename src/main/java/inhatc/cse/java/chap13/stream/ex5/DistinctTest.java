package inhatc.cse.java.chap13.stream.ex5;

import java.util.ArrayList;
import java.util.List;

public class DistinctTest {

    public static void main(String[] args) {
        Student studentLee = new Student(100, "이윤선");
        Student studentMoon = new Student(200, "문찬욱");
        Student studentLee2 = new Student(100, "이윤선");

        List<Student> studentList = new ArrayList<>();
        studentList.add(studentLee);
        studentList.add(studentMoon);
        studentList.add(studentLee2);

        studentList.stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("---------------------");

        studentList.stream()
                .distinct() // 같은 멤버는 제외하기
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("---------------------");

        studentList.stream()
                .distinct()
                .forEach(s -> System.out.println(s.getName() + "님 안녕하세요"));
    }
}