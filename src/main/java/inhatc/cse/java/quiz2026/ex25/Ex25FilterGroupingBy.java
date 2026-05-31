package inhatc.cse.java.quiz2026.ex25;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * filter + groupingBy 조합 - 조건으로 필터링 후 그룹화
 */
public class Ex25FilterGroupingBy {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "cool", "stream", "lambda", "a");

        System.out.println("원본: " + words);

        // filter()로 길이 3 이상만 선택한 후, groupingBy()로 길이별 그룹화
        Map<Integer, List<String>> grouped = words.stream()
                                                   .filter(w -> w.length() >= 3)  // 길이 3 이상만
                                                   .collect(Collectors.groupingBy(String::length));  // 길이별 그룹화

        System.out.println("\n길이 3 이상인 단어들을 길이별로 그룹화:");
        grouped.forEach((length, wordList) -> System.out.println("길이 " + length + " : " + wordList));
    }
}

