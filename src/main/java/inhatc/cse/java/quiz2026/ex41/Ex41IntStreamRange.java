package inhatc.cse.java.quiz2026.ex41;

import java.util.stream.IntStream;

/**
 * 난이도: 상
 * IntStream.range - 범위의 정수 스트림 생성
 */
public class Ex41IntStreamRange {
    public static void main(String[] args) {
        System.out.println("1부터 20까지 중 3의 배수:");
        
        // IntStream.range()로 1~20 범위 생성
        long count = IntStream.rangeClosed(1, 20)  // 1부터 20까지 포함
                              .filter(n -> n % 3 == 0)  // 3의 배수만
                              .peek(System.out::println)  // 선택된 숫자 출력
                              .count();  // 개수
        
        // 합계 계산
        int sum = IntStream.rangeClosed(1, 20)
                           .filter(n -> n % 3 == 0)
                           .sum();  // 합계
        
        System.out.println("개수: " + count);
        System.out.println("합계: " + sum);
    }
}

