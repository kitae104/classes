package inhatc.cse.java.quiz2026.ex07;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * filter와 map 조합
 */
public class Ex07FilterMapCombine {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 15, 3, 20, 8, 25, 12);
        
        System.out.println("원본 숫자: " + numbers);
        System.out.println("\n10 이상인 숫자를 2배로 변환:");
        
        // filter로 조건에 맞는 요소 필터링 후, map으로 변환
        numbers.stream()
               .filter(n -> n >= 10)  // 10 이상만 통과
               .map(n -> n * 2)       // 2배로 변환
               .forEach(System.out::println);
    }
}

