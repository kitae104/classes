package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A반 1번 (난이도: 하)
 * filter + map + sorted + collect
 *
 * 가격이 20,000원 이상인 도서의 "제목"만 골라
 * 제목 가나다순(오름차순)으로 정렬하여 출력한다.
 */
public class Ex1 {

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

        // filter(20000원 이상) -> map(제목) -> sorted(가나다순) -> collect
        List<String> result = books.stream()
                .filter(b -> b.getPrice() >= 20000)
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("== 20,000원 이상 도서 (제목 가나다순) ==");
        result.forEach(System.out::println);
    }
}
