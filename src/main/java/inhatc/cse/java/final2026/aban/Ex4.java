package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A반 4번 (난이도: 중상)
 * groupingBy + counting + entrySet 스트림 + sorted(다중 정렬) + forEach
 *
 * 카테고리별 도서 "권수"를 구한 뒤,
 * 권수 내림차순(권수가 같으면 카테고리명 오름차순)으로 정렬하여 출력한다.
 */
public class Ex4 {

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

        // groupingBy(카테고리) + counting() 으로 카테고리별 권수 계산
        Map<String, Long> countByCategory = books.stream()
                .collect(Collectors.groupingBy(Book::getCategory, Collectors.counting()));

        System.out.println("== 카테고리별 도서 권수 (권수 내림차순, 동률은 카테고리명 오름차순) ==");
        countByCategory.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed()
                                  .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "권"));
    }
}
