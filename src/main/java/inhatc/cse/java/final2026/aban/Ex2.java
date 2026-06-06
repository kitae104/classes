package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A반 2번 (난이도: 중하)
 * filter + sorted(내림차순) + map + forEach
 *
 * '프로그래밍' 카테고리 도서만 골라
 * 가격이 비싼 순(내림차순)으로 정렬한 뒤 "제목 - 가격원" 형식으로 출력한다.
 */
public class Ex2 {

    static class Book {
        String title;
        String author;
        String category;
        int price;
        int stock;

        public Book(String title, String author, String category, int price, int stock) {
            this.title = title;
            this.author = author;
            this.category = category;
            this.price = price;
            this.stock = stock;
        }

        public String getTitle() { return title; }
        public String getCategory() { return category; }
        public int getPrice() { return price; }
        public int getStock() { return stock; }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("자바의정석", "남궁성", "프로그래밍", 30000, 15),
            new Book("이펙티브자바", "조슈아", "프로그래밍", 36000, 8),
            new Book("클린코드", "로버트", "프로그래밍", 33000, 5),
            new Book("데미안", "헤세", "소설", 12000, 20),
            new Book("어린왕자", "생텍쥐페리", "소설", 9000, 25),
            new Book("코스모스", "세이건", "과학", 18000, 12),
            new Book("이기적유전자", "도킨스", "과학", 20000, 7),
            new Book("총균쇠", "다이아몬드", "역사", 22000, 10)
        );

        System.out.println("== 프로그래밍 도서 (가격 내림차순) ==");
        books.stream()
             .filter(b -> b.getCategory().equals("프로그래밍"))
             .sorted(Comparator.comparingInt(Book::getPrice).reversed())
             .map(b -> b.getTitle() + " - " + b.getPrice() + "원")
             .forEach(System.out::println);
    }
}
