package inhatc.cse.java.quiz2026.ex13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 하
 * sorted + Comparator - Lambda를 이용한 정렬
 */
public class Ex13LambdaComparator {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Zebra", "Apple", "Mango", "Banana", "Cherry");
        
        System.out.println("원본 리스트: " + words);
        
        // sorted()에 Comparator를 lambda로 전달하여 정렬
        List<String> sorted = words.stream()
                                    .sorted((a, b) -> a.compareTo(b))  // 오름차순 정렬
                                    .collect(Collectors.toList());
        
        System.out.println("오름차순 정렬: " + sorted);
    }
}

