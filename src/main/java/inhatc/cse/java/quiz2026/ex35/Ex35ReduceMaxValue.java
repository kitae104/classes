package inhatc.cse.java.quiz2026.ex35;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 난이도: 상
 * reduce로 최댓값 구하기
 */
public class Ex35ReduceMaxValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 67, 23, 89, 34, 78, 56, 90);

        System.out.println("숫자 리스트: " + numbers);

        // reduce()를 사용하여 최댓값 구하기
        // 초기값을 사용하지 않고 reduce(누적함수)만 사용하면 Optional 반환
        Optional<Integer> max = numbers.stream()
                                        .reduce(Math::max);  // 두 값 중 큰 것을 선택

        if (max.isPresent()) {
            System.out.println("최댓값: " + max.get());
        }
    }
}

