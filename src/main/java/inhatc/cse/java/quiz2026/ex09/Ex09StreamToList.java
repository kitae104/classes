package inhatc.cse.java.quiz2026.ex09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 하
 * Stream toList - 필터링된 결과를 새 List로 생성
 */
public class Ex09StreamToList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 15);
        
        System.out.println("원본 숫자: " + numbers);
        
        // filter()로 3의 배수 선택 후 collect()로 새 List 생성
        List<Integer> multiplesOf3 = numbers.stream()
                                             .filter(n -> n % 3 == 0)  // 3의 배수
                                             .collect(Collectors.toList());  // List로 변환
        
        System.out.println("3의 배수: " + multiplesOf3);
    }
}

