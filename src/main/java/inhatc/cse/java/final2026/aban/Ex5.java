package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A반 5번 (난이도: 상)
 * filter + groupingBy + summingInt + entrySet 스트림 + sorted + map + joining
 *
 * 재고(stock)가 10권 이상인 도서만 대상으로,
 * 카테고리별 "정가 합계(price 합)"를 구한 뒤,
 * 합계 내림차순으로 정렬하여 "카테고리(합계원)" 형식을 " > "로 이어 한 줄로 출력한다.
 * 추가로, 그 중 합계가 가장 큰 카테고리 이름을 따로 출력한다.
 */
public class Ex5 {

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

        // 1. filter(재고 10권 이상) -> 2. groupingBy(카테고리) + summingInt(정가)
        Map<String, Integer> sumByCategory = books.stream()
                .filter(b -> b.getStock() >= 10)
                .collect(Collectors.groupingBy(Book::getCategory,
                                               Collectors.summingInt(Book::getPrice)));

        // 3. entrySet 스트림 -> sorted(합계 내림차순) -> map(형식) -> joining
        String line = sumByCategory.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed())
                .map(e -> e.getKey() + "(" + e.getValue() + "원)")
                .collect(Collectors.joining(" > "));

        System.out.println("== 재고 10권 이상, 카테고리별 정가 합계 (내림차순) ==");
        System.out.println(line);

        // 추가: 합계가 가장 큰 카테고리
        String topCategory = sumByCategory.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("없음");

        System.out.println("정가 합계 1위 카테고리: " + topCategory);
    }
}
