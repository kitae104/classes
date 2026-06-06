package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A반 3번 (난이도: 중)
 * partitioningBy + map + forEach
 *
 * 가격 20,000원을 기준으로 도서를 두 그룹(이상 / 미만)으로 분할하고,
 * 각 그룹의 도서 "제목"을 출력한다.
 */
public class Ex3 {

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

        // partitioningBy(20000원 이상 여부)로 두 그룹으로 분할
        Map<Boolean, List<Book>> partitioned = books.stream()
                .collect(Collectors.partitioningBy(b -> b.getPrice() >= 20000));

        System.out.println("[20,000원 이상]");
        partitioned.get(true).forEach(b -> System.out.println("  " + b.getTitle()));

        System.out.println("[20,000원 미만]");
        partitioned.get(false).forEach(b -> System.out.println("  " + b.getTitle()));
    }
}
