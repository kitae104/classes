package inhatc.cse.java.quiz2026.ex22;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * groupingBy - 요소를 키 기준으로 그룹화
 */
public class Ex22GroupingByBasic {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // groupingBy()로 홀짝 여부로 그룹화
        Map<String, List<Integer>> grouped = numbers.stream()
                                                     .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        
        System.out.println("\n그룹화 결과:");
        grouped.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}

