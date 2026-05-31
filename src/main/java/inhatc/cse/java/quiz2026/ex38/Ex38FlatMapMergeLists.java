package inhatc.cse.java.quiz2026.ex38;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 난이도: 상
 * flatMap으로 여러 리스트 합치기
 */
public class Ex38FlatMapMergeLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        
        System.out.println("리스트 1: " + list1);
        System.out.println("리스트 2: " + list2);
        
        // Stream.of()로 두 개의 Stream을 만들고 flatMap()으로 평탄화
        List<Integer> merged = Stream.of(list1, list2)
                                      .flatMap(List::stream)  // 각 리스트를 Stream으로 변환하여 평탄화
                                      .sorted()  // 오름차순 정렬
                                      .collect(Collectors.toList());
        
        System.out.println("합쳐진 리스트: " + merged);
    }
}

