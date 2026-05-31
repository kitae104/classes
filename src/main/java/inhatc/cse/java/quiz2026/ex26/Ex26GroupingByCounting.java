package inhatc.cse.java.quiz2026.ex26;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * groupingBy + counting - 그룹별 요소 개수 계산
 */
public class Ex26GroupingByCounting {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "cool", "stream", "lambda", "programming");
        
        System.out.println("단어 리스트: " + words);
        
        // groupingBy()와 counting()을 조합하여 길이별 개수 계산
        Map<Integer, Long> lengthCount = words.stream()
                                               .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        
        System.out.println("\n길이별 단어 개수:");
        lengthCount.forEach((length, count) -> System.out.println("길이 " + length + " : " + count + "개"));
    }
}

