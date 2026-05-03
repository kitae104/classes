package inhatc.cse.java.stream.ex1_basic;

import java.util.List;

/**
 * 상품 목록에서 카테고리가 `BOOK`인 항목의 가격 합계를 구하세요.
 *
 * ## 데이터
 * - ("Java Basic", "BOOK", 18000)
 * - ("Keyboard", "DEVICE", 45000)
 * - ("Stream Guide", "BOOK", 22000)
 * - ("Mouse", "DEVICE", 25000)
 */
public class Ex3 {

    public static void main(String[] args) {
        record Product(String name, String category, int price) {}

        int totalPrice = List.of(
                        new Product("Java Basic", "BOOK", 18000),
                        new Product("Keyboard", "DEVICE", 45000),
                        new Product("Stream Guide", "BOOK", 22000),
                        new Product("Mouse", "DEVICE", 25000))
                .stream()
                .filter(product -> product.category().equals("BOOK")) // 카테고리 필터링
                .mapToInt(product -> product.price()) // 가격 추출
                .sum(); // 가격 합계 계산

        System.out.println(totalPrice);
    }
}
