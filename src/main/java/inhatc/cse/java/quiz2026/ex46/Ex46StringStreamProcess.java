package inhatc.cse.java.quiz2026.ex46;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * 문자열 처리 - split + groupingBy
 */
public class Ex46StringStreamProcess {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        
        System.out.println("원본 문장: " + sentence);
        
        // split()으로 단어 분리 후 groupingBy로 길이별 그룹화
        Map<Integer, List<String>> grouped = Arrays.stream(sentence.split(" "))
                                                    .collect(Collectors.groupingBy(String::length,
                                                                                    Collectors.collectingAndThen(
                                                                                        Collectors.toList(),
                                                                                        list -> list.stream()
                                                                                                  .sorted()  // 각 그룹 내 길이 정렬
                                                                                                  .collect(Collectors.toList()))));
        
        System.out.println("\n단어 길이별 그룹화 (그룹 내 알파벳순):");
        grouped.forEach((length, words) -> 
            System.out.println("길이 " + length + " : " + words)
        );
    }
}

