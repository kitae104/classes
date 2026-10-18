package inhatc.cse.java.stream.days;

import java.util.Arrays;

/**
 * 문제 1. 람다와 스트림 — 짝수의 제곱 합계
 * 다음 정수 배열에서 짝수만 추출하고, 각 숫자를 제곱한 뒤 모든 값을 합산하는 프로그램을 작성하세요.
 * int[] data = {3, 8, 12, 5, 7, 10, 4, 9};
 */
public class Day1 {
    public static void main(String[] args) {
        int[] data = {3, 8, 12, 5, 7, 10, 4, 9};

        // 스트림을 사용하여 짝수의 제곱 합계를 계산
        int[] squaresArr = Arrays.stream(data) // 배열을 스트림으로 변환
                .filter(n -> n % 2 == 0) // 짝수만 필터링
                .map(n -> n * n) // 각 숫자를 제곱
                .toArray(); // 결과를 배열로 변환
        System.out.println("짝수의 제곱 배열: " + Arrays.toString(squaresArr));

        int sumOfSquares = Arrays.stream(data) // 배열을 스트림으로 변환
                .filter(n -> n % 2 == 0) // 짝수만 필터링
                .map(n -> n * n) // 각 숫자를 제곱
                .sum(); // 모든 값을 합산

        System.out.println("짝수의 제곱 합계: " + sumOfSquares);
    }
}
