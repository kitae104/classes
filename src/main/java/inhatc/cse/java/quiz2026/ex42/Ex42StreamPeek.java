package inhatc.cse.java.quiz2026.ex42;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * peek - 중간 결과를 디버깅 목적으로 출력
 */
public class Ex42StreamPeek {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        
        System.out.println("원본: " + numbers);
        System.out.println("\nStream 중간 과정:");
        
        // filter -> peek -> map -> peek 순서로 처리하여 각 단계 확인
        List<Integer> result = numbers.stream()
                                       .filter(n -> n % 2 == 0)  // 짝수만
                                       .peek(n -> System.out.println("  filter 통과: " + n))  // 필터링 후 값
                                       .map(n -> n * 2)  // 2배 변환
                                       .peek(n -> System.out.println("  map 완료: " + n))  // 변환 후 값
                                       .collect(Collectors.toList());
        
        System.out.println("\n최종 결과: " + result);
    }
}

