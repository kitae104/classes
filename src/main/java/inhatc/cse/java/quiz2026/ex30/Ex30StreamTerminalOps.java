package inhatc.cse.java.quiz2026.ex30;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 중
 * 여러 종단 작업 조합 - count, sum, average 함께 사용
 */
public class Ex30StreamTerminalOps {

    // 간단한 Book 클래스
    static class Book {
        String id;
        String title;
        int price;

        public Book(String id, String title, int price) {
            this.id = id;
            this.title = title;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("B001", "Java Basics", 2500),
            new Book("B002", "Python Guide", 1800),
            new Book("B003", "Spring Boot", 3000),
            new Book("B004", "SQL Query", 1500),
            new Book("B005", "Clean Code", 2200)
        );

        System.out.println("원본 도서 리스트:");
        books.forEach(b -> System.out.println(b.title + " : " + b.price + "원"));

        // 2000원 이상인 도서들의 개수와 총액 구하기
        List<Book> filtered = books.stream()
                                     .filter(b -> b.getPrice() >= 2000)
                                     .toList();

        long count = filtered.stream().count();  // 개수 구하기
        long sum = filtered.stream()
                           .mapToLong(Book::getPrice)
                           .sum();  // 총액 구하기
        double average = count > 0 ? (double) sum / count : 0;  // 평균 계산

        System.out.println("\n2000원 이상인 도서:");
        System.out.println("개수: " + count + "권");
        System.out.println("총액: " + sum + "원");
        System.out.println("평균 가격: " + String.format("%.2f", average) + "원");
    }
}

