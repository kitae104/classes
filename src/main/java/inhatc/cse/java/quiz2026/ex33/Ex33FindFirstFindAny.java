package inhatc.cse.java.quiz2026.ex33;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 난이도: 상
 * findFirst/findAny - Optional을 반환하는 종단 작업
 */
public class Ex33FindFirstFindAny {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 30, 60, 40, 70, 50);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // findFirst()로 50보다 큰 첫 번째 요소를 찾기
        Optional<Integer> first = numbers.stream()
                                          .filter(n -> n > 50)  // 50보다 큰 것만
                                          .findFirst();  // 첫 번째 요소 찾기
        
        // Optional 값이 있으면 출력
        if (first.isPresent()) {
            System.out.println("50보다 큰 첫번째 숫자: " + first.get());
        } else {
            System.out.println("50보다 큰 숫자가 없습니다.");
        }
        
        // 더 간결한 방법: ifPresent 또는 ifPresentOrElse 사용
        System.out.println("\nifPresent 사용:");
        first.ifPresent(value -> System.out.println("값: " + value));
    }
}

