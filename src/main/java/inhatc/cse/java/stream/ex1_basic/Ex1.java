package inhatc.cse.java.stream.ex1_basic;

import java.util.List;

/**
 * Stream filter/sorted
 *
 * 정수 점수 리스트에서 70점 이상만 추출한 뒤 내림차순 정렬하여 새 리스트를 만드세요.
 *
 * ## 데이터
 * `[55, 80, 70, 92, 67, 100, 88]`
 */
public class Ex1 {
    public static void main(String[] args) {
        List<Integer> newList = List.of(55, 80, 70, 92, 67, 100, 88)
                .stream()
                .filter(score -> score >= 70) // 70점 이상 필터링
                .sorted((a, b) -> b - a) // 내림차순 정렬
                .toList();

        System.out.println(newList);
    }
}
