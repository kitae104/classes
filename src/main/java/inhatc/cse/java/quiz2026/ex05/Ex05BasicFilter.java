package inhatc.cse.java.quiz2026.ex05;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * Stream 기본 filter
 */
public class Ex05BasicFilter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 15, 3, 20, 8, 25, 12, 7);

        System.out.println("원본 숫자: " + numbers);
        System.out.println("\n10 이상인 숫자들:");

        // filter()를 사용하여 10 이상인 숫자만 필터링
        numbers.stream()
               .filter(n -> n >= 10)  // 10 이상인 조건
               .forEach(System.out::println);
    }
}

