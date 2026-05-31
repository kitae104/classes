package inhatc.cse.java.quiz2026.ex06;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * Stream map - 요소를 변환
 */
public class Ex06BasicMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "Lambda", "Filter", "Map");
        
        System.out.println("원본 문자열: " + words);
        System.out.println("\n각 문자열의 길이:");
        
        // map()을 사용하여 String 타입을 Integer(길이)로 변환
        words.stream()
             .map(String::length)  // 각 문자열의 길이 추출
             .forEach(System.out::println);
    }
}

