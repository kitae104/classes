package inhatc.cse.java.quiz.a;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ex1Answer {

    static class Student {
        private final int no;
        private final String name;

        Student(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Student other)) {
                return false;
            }
            return no == other.no;
        }

        @Override
        public int hashCode() {
            return Objects.hash(no);
        }

        @Override
        public String toString() {
            return "Student{no=" + no + ", name='" + name + "'}";
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student(1001, "Kim"));
        students.add(new Student(1001, "Kim-dup"));
        students.add(new Student(1002, "Lee"));
        students.add(new Student(1003, "Park"));
        students.add(new Student(1002, "Lee-dup"));

        System.out.println("size=" + students.size());
        students.stream()
                .sorted(Comparator.comparingInt(Student::getNo))
                .forEach(System.out::println);
    }
}
