package inhatc.cse.java.quiz2026.ex15;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * max/min + IntStream - 최댓값과 최솟값 구하기
 */
public class Ex15StreamMaxMin {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 23, 78, 12, 56, 89, 34, 67);

        System.out.println("숫자 리스트: " + numbers);

        // mapToInt()로 IntStream으로 변환 후 max(), min() 사용
        int max = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .max()  // 최댓값
                         .orElse(0);  // 결과가 없으면 0 반환

        int min = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .min()  // 최솟값
                         .orElse(0);

        System.out.println("최댓값: " + max);
        System.out.println("최솟값: " + min);
    }
}

