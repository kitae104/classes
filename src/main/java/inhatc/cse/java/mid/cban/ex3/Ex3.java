package inhatc.cse.java.mid.cban.ex3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
아래 데이터를 이용하여 해당 기능을 구현하세요.
("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE)
("B002", "스프링 입문", "김영한", BookStatus.RENTED)
("B003", "이펙티브 자바", "조슈아 블로크", BookStatus.AVAILABLE)
("B004", "혼자 공부하는 자바", "신용권", BookStatus.AVAILABLE)
("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE)

1. 대출 가능한 도서만 출력하시오.
2. 저자명 기준 오름차순 정렬하여 출력하시오.
3. 제목에 "자바"가 포함된 도서만 출력하시오.
4. 도서 상태별 권수를 출력하시오.
5. 제목 길이가 가장 긴 도서를 출력하시오.
 */
public class Ex3 {
    public static void main(String[] args) {
        List<BookInfo> books = List.of(
                new BookInfo("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE),
                new BookInfo("B002", "스프링 입문", "김영한", BookStatus.RENTED),
                new BookInfo("B003", "이펙티)브 자바", "조슈아 블로크", BookStatus.AVAILABLE),
                new BookInfo("B004", "혼자 공부하는 자바", "신용권", BookStatus.AVAILABLE),
                new BookInfo("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE)
        );

        // 1) 대출 가능한 도서만 출력
        System.out.println("\n==== 1) 대출 가능한 도서(AVAILABLE) ====");
        books.stream()
                .filter(b -> b.getBookStatus() == BookStatus.AVAILABLE)
                .forEach(System.out::println);

        // 2) 저자명 기준 오름차순 정렬
        System.out.println("\n==== 2) 저자명 기준 오름차순 ====");
        books.stream()
                .sorted(Comparator.comparing(BookInfo::getAuthor))
                .forEach(System.out::println);

        // 3) 제목에 "자바" 포함
        System.out.println("\n==== 3) 제목에 '자바' 포함 ====");
        books.stream()
                .filter(b -> b.getBookName().contains("자바"))
                .forEach(System.out::println);

        // 4) 도서 상태별 권수
        System.out.println("\n==== 4) 상태별 권수 ====");
        long count1 = books.stream()
                .filter(b -> b.getBookStatus() == BookStatus.AVAILABLE)
                .count();
        long count2 = books.stream()
                .filter(b -> b.getBookStatus() == BookStatus.RENTED)
                .count();
        System.out.println("AVAILABLE : " + count1);
        System.out.println("RENTED : " + count2);

        Map<BookStatus, Long> statusCount = books.stream()
                .collect(Collectors.groupingBy(BookInfo::getBookStatus, Collectors.counting()));

        statusCount.forEach((status, count) ->
                System.out.println(status + " : " + count));


        // 5) 제목 길이가 가장 긴 도서
        System.out.println("\n==== 5) 제목 길이가 가장 긴 도서 ====");
        books.stream()
                .max(Comparator.comparingInt(b -> b.getBookName().length()))
                .ifPresent(System.out::println);

        books.stream()
                .sorted((b1, b2) -> b2.getBookName().length() - b1.getBookName().length())
                .limit(1)
                .forEach(System.out::println);
    }
}
