package inhatc.cse.java.quiz.b;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ex1Answer {

    static class Course {
        private final String code;
        private final String title;

        Course(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Course other)) {
                return false;
            }
            return Objects.equals(code, other.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }

        @Override
        public String toString() {
            return "Course{code='" + code + "', title='" + title + "'}";
        }
    }

    public static void main(String[] args) {
        Set<Course> courses = new HashSet<>();
        courses.add(new Course("CS101", "Java"));
        courses.add(new Course("CS101", "Java-dup"));
        courses.add(new Course("CS102", "DB"));
        courses.add(new Course("CS103", "Network"));
        courses.add(new Course("CS102", "DB-dup"));

        System.out.println("size=" + courses.size());
        courses.stream()
                .sorted(Comparator.comparing(Course::getCode))
                .forEach(System.out::println);
    }
}
