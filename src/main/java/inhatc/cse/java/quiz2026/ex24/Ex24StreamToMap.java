package inhatc.cse.java.quiz2026.ex24;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * toMap - Stream을 Map으로 변환
 */
public class Ex24StreamToMap {
    public static void main(String[] args) {
        // AbstractMap.SimpleEntry를 사용하여 쌍을 표현
        List<Map.Entry<String, Integer>> entries = Arrays.asList(
            new AbstractMap.SimpleEntry<>("A", 10),
            new AbstractMap.SimpleEntry<>("B", 20),
            new AbstractMap.SimpleEntry<>("C", 30)
        );
        
        System.out.println("원본 (key, value) 쌍:");
        entries.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        
        // toMap()으로 Stream을 Map으로 변환
        Map<String, Integer> map = entries.stream()
                                           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println("\nMap으로 변환:");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}

