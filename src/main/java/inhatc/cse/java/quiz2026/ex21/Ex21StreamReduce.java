package inhatc.cse.java.quiz2026.ex21;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 중
 * reduce - 누적 함수로 하나의 값으로 축약
 */
public class Ex21StreamReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // reduce()를 사용하여 모든 요소를 더함
        // 초기값 0부터 시작하여 각 요소를 누적으로 더함
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);  // 초기값 0, 누적 함수
        
        System.out.println("합계: " + sum);
    }
}

