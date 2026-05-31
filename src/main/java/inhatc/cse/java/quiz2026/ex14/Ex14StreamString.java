package inhatc.cse.java.quiz2026.ex14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 하
 * map + String 메서드 - 문자열 변환
 */
public class Ex14StreamString {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "lambda", "filter");
        
        System.out.println("원본: " + words);
        
        // map()으로 각 문자열을 대문자로 변환
        List<String> uppercase = words.stream()
                                       .map(String::toUpperCase)  // 대문자로 변환
                                       .collect(Collectors.toList());
        
        System.out.println("대문자 변환: " + uppercase);
    }
}

