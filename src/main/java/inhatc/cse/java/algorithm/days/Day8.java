package inhatc.cse.java.algorithm.days;

import java.util.Arrays;

/**
 * 누적 합(Prefix Sum)을 이용한 구간 합 계산
 *
 * [요구사항]
 * 1. for 반복문을 사용한다.
 * 2. 누적 합 배열을 생성한다.
 * 3. 누적 합 배열 크기는 data.length + 1이다.
 * 4. 구간의 양 끝 인덱스를 모두 포함한다.
 * 5. 각 구간의 합을 O(1)에 계산한다.
 * 6. 전체 시간 복잡도는 O(n + q)를 목표로 한다.
 * 7. 누적 합은 long 자료형을 사용한다.
 * 8. stream()은 사용하지 않는다.
 * 9. 모든 구간 인덱스는 유효하다고 가정한다.
 */
public class Day8 {
    public static void main(String[] args) {
        int[] data = {5, 3, 8, 6, 2, 7, 4, 9};
        int[][] queries = {{0, 3}, {2, 5}, {1, 6}, {4, 7}, {0, 7}};

        System.out.println("원본 배열 :");
        System.out.println(Arrays.toString(data));

        // TODO 1. 누적 합 배열 생성
        long[] prefixSum = new long[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + data[i];
        }
        System.out.println("\n누적 합 배열: ");
        System.out.println(Arrays.toString(prefixSum));

        // TODO 2. 각 구간 합 계산
        System.out.println("\n구간 합 계산:");
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            long sum = prefixSum[end + 1] - prefixSum[start];
            System.out.println("구간 [" + start + ", " + end + "]의 합: " + sum);
        }
    }
}
