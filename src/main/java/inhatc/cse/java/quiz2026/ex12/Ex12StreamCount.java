package inhatc.cse.java.quiz2026.ex12;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * count - 필터링된 요소의 개수 계산
 */
public class Ex12StreamCount {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(30, 60, 40, 70, 20, 55, 80, 35);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // filter()로 조건에 맞는 요소만 선택한 후 count()로 개수 계산
        long count = numbers.stream()
                            .filter(n -> n > 50)  // 50 초과인 숫자만 선택
                            .count();  // 개수 반환
        
        System.out.println("50 초과인 숫자 개수: " + count);
    }
}

