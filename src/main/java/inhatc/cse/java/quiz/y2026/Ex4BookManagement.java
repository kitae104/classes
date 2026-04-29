package inhatc.cse.java.quiz.y2026;

import java.util.*;
import java.util.stream.Collectors;

public class Ex4BookManagement {

    enum BookStatus { AVAILABLE, RENTED }

    static class Book {
        private final String code;
        private final String title;
        private final String author;
        private final BookStatus status;

        Book(String code, String title, String author, BookStatus status) {
            this.code = code;
            this.title = title;
            this.author = author;
            this.status = status;
        }

        public String getCode() { return code; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public BookStatus getStatus() { return status; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Objects.equals(code, book.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }

        @Override
        public String toString() {
            return String.format("Book{code='%s', title='%s', author='%s', status=%s}", code, title, author, status);
        }
    }

    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();

        books.add(new Book("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE));
        books.add(new Book("B002", "스프링 입문", "김영한", BookStatus.RENTED));
        books.add(new Book("B003", "이펙티브 자바", "조슈아 블로크", BookStatus.AVAILABLE));
        books.add(new Book("B004", "혼자 공부하는 자바", "신용권", BookStatus.AVAILABLE));
        books.add(new Book("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE));

        System.out.println("==== 원본 Set (중복제거 적용) ====");
        books.forEach(System.out::println);

        // 1) 대출 가능한 도서만 출력
        System.out.println("\n==== 1) 대출 가능한 도서(AVAILABLE) ====");
        books.stream()
                .filter(b -> b.getStatus() == BookStatus.AVAILABLE)
                .forEach(System.out::println);

        // 2) 저자명 기준 오름차순 정렬
        System.out.println("\n==== 2) 저자명 기준 오름차순 ====");
        books.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .forEach(System.out::println);

        // 3) 제목에 "자바" 포함
        System.out.println("\n==== 3) 제목에 '자바' 포함 ====");
        books.stream()
                .filter(b -> b.getTitle().contains("자바"))
                .forEach(System.out::println);

        // 4) 도서 상태별 권수
        System.out.println("\n==== 4) 상태별 권수 ====");
        Map<BookStatus, Long> byStatus = books.stream()
                .collect(Collectors.groupingBy(Book::getStatus, Collectors.counting()));
        for (BookStatus s : BookStatus.values()) {
            System.out.printf("%s : %d%n", s, byStatus.getOrDefault(s, 0L));
        }

        // 5) 제목 길이가 가장 긴 도서
        System.out.println("\n==== 5) 제목 길이가 가장 긴 도서 ====");
        books.stream()
                .max(Comparator.comparingInt(b -> b.getTitle().length()))
                .ifPresent(System.out::println);
    }
}

