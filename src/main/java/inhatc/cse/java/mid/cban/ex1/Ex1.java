package inhatc.cse.java.mid.cban.ex1;

import java.util.List;

/*
도서 정보를 저장하는 프로그램을 작성하시오.
- 도서 정보는 도서번호, 도서명, 가격으로 구성된다.
- 이 정보를 record로 작성하시오.

프로그램에서는 다음 작업을 수행해야 한다.
- 도서 객체 5개(2개는 2만원 미만, 3개는 이상)를 임의로 생성하여 리스트에 저장한다.
- 가격이 20,000원 이상인 도서만 출력한다.
조건:
도서 정보는 변경되지 않는다고 가정한다.
record를 사용하여 간단하게 객체를 정의하시오.
 */
public class Ex1 {
    public static void main(String[] args) {
        var books = List.of(
                new Book("B001", "자바의 정석", 18_000),
                new Book("B002", "스프링 입문", 22_000),
                new Book("B003", "이펙티브 자바", 25_000),
                new Book("B004", "혼자 공부하는 자바", 30_000),
                new Book("B005", "자바 프로그래밍", 15_000)
        );

        books.stream()
                .filter(book -> book.price() >= 20_000)
                .forEach(System.out::println);
    }
}
