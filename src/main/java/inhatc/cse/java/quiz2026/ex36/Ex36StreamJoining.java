package inhatc.cse.java.quiz2026.ex36;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * Collectors.joining - 요소들을 문자열로 연결
 */
public class Ex36StreamJoining {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");
        
        System.out.println("원본 리스트: " + fruits);
        
        // Collectors.joining()으로 요소들을 문자열로 연결
        String result = fruits.stream()
                               .collect(Collectors.joining(", ", "[", "]"));
        
        System.out.println("joining() 결과: " + result);
    }
}

