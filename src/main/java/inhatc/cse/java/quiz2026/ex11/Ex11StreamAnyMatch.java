package inhatc.cse.java.quiz2026.ex11;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 하
 * anyMatch - 조건을 만족하는 요소가 하나라도 있는지 확인
 */
public class Ex11StreamAnyMatch {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> numbers2 = Arrays.asList(10, 20, 100, 40);
        
        System.out.println("숫자 리스트 1: " + numbers1);
        // anyMatch()는 조건을 만족하는 요소가 하나라도 있으면 true
        boolean hasOver100_1 = numbers1.stream()
                                        .anyMatch(n -> n >= 100);  // 100 이상인 요소가 있는가?
        System.out.println("100 이상인 숫자 존재: " + hasOver100_1);
        
        System.out.println("\n숫자 리스트 2: " + numbers2);
        boolean hasOver100_2 = numbers2.stream()
                                        .anyMatch(n -> n >= 100);
        System.out.println("100 이상인 숫자 존재: " + hasOver100_2);
    }
}

