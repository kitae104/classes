package inhatc.cse.java.quiz2026.ex08;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * Stream sum - IntStream으로 변환해 합계 구하기
 */
public class Ex08StreamSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // mapToInt()로 IntStream으로 변환하여 sum() 사용
        int sum = numbers.stream()
                         .mapToInt(Integer::intValue)  // Integer를 int로 변환
                         .sum();  // 합계 계산
        
        System.out.println("합계: " + sum);
    }
}

