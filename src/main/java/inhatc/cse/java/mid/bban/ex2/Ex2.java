package inhatc.cse.java.mid.bban.ex2;

import java.util.List;

/*
countGreaterThan(List<T> values, T pivot) 제네릭 메서드를 작성하세요.

요구사항
● T는 비교 가능한 타입이어야 합니다.
● pivot보다 큰 원소 개수를 반환하세요.
● 테스트 데이터: [3, 7, 1, 9, 5], pivot=4
 */
public class Ex2 {
    public static void main(String[] args) {
        List<Integer> values = List.of(3, 7, 1, 9, 5);
        long count = countGreaterThan(values, 4);
        System.out.println(count);

    }

    private static <T extends Number> long countGreaterThan(List<T> values, T pivot) {
        long count = values.stream()
                .filter(value -> value.doubleValue() > pivot.doubleValue())
                .count();
        return count;
    }
}
