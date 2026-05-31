package inhatc.cse.java.quiz2026.ex20;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 중
 * allMatch/noneMatch - 모든 요소에 대한 조건 검사
 */
public class Ex20AllMatchNoneMatch {
    public static void main(String[] args) {
        List<Integer> positives = Arrays.asList(5, 10, 15, 20);
        List<Integer> mixed = Arrays.asList(-5, -10, 15);

        System.out.println("리스트 1: " + positives);
        // allMatch()는 모든 요소가 조건을 만족해야 true
        boolean allPositive = positives.stream()
                                        .allMatch(n -> n > 0);  // 모두 양수인가?
        System.out.println("모두 양수인가? " + allPositive);

        System.out.println("\n리스트 2: " + mixed);
        // noneMatch()는 모든 요소가 조건을 만족하지 않아야 true
        boolean notAllPositive = mixed.stream()
                                       .noneMatch(n -> n > 0);  // 모두 양수가 아닌가?
        System.out.println("모두 음수인가(양수가 전혀 없는가)? " + notAllPositive);
    }
}

