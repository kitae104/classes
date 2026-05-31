package inhatc.cse.java.quiz2026.ex10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 하
 * filter + map + collect - 조건 필터링 후 변환해 리스트 생성
 */
public class Ex10ForeachVsCollect {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("원본 숫자: " + numbers);

        // 짝수만 필터링한 후 제곱값으로 변환
        List<Integer> squares = numbers.stream()
                                        .filter(n -> n % 2 == 0)  // 짝수만 선택
                                        .map(n -> n * n)           // 제곱값 계산
                                        .collect(Collectors.toList());  // 새 List 생성

        System.out.println("짝수들의 제곱값: " + squares);
    }
}

