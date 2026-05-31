package inhatc.cse.java.quiz2026.ex19;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 중
 * flatMap - 스트림 평탄화
 */
public class Ex19FlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Java");
        
        System.out.println("원본 문자열: " + words);
        System.out.println("\nflatMap으로 각 문자 분리:");
        
        // flatMap()으로 각 문자열을 문자들의 스트림으로 변환하여 평탄화
        words.stream()
             .flatMap(s -> Arrays.stream(s.split("")))  // 각 문자를 분리해 스트림으로 변환
             .forEach(System.out::println);
    }
}

