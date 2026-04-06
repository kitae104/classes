package inhatc.cse.java.chap13.ex3_stream.ex1_basic;

import java.util.Arrays;

// 정수 배열에 스트림 생성하고 사용하기
public class IntArrayTest {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        int sumVal = Arrays.stream(arr).sum();
        System.out.println(sumVal);

        int count = (int) Arrays.stream(arr).count();
        System.out.println(count);

        // 배열 요소를 모두 더해 하나의 정수로 반환
        // reduce(0, (a, b) -> a + b): 누적 연산.
        // 0은 초기값이고, (a,b)는 누적값 a와 현재 요소 b를 더하는 람다식.
        System.out.println(Arrays.stream(arr).reduce(0, (a,b)->a+b));

    }
}