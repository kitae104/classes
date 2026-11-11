package inhatc.cse.java.algorithm.days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap과 누적 합으로 부분 배열 개수 계산
 *
 * [요구사항]
 * 1. HashMap을 사용한다.
 * 2. for 반복문으로 배열을 한 번 순회한다.
 * 3. 누적 합을 계산한다.
 * 4. 이전에 등장한 누적 합의 횟수를 저장한다.
 * 5. 조건에 맞는 연속 부분 배열 개수를 계산한다.
 * 6. 음수와 0이 포함되어도 동작해야 한다.
 * 7. 목표 시간 복잡도는 평균 O(n)이다.
 * 8. 누적 합과 결과 개수는 long을 사용한다.
 * 9. 이중 반복문은 사용하지 않는다.
 */
public class Day9 {
    public static void main(String[] args) {

        int[] data = {3, 1, 2, -1, 2, -2, 4};
        int target = 4;

        long result = countSubarrays(data, target);

        System.out.println(Arrays.toString(data));
        System.out.println("목표 합계: " + target);
        System.out.println("부분 배열 개수: " + result);
    }

    public static long countSubarrays(int[] data, int target) {

        Map<Long, Integer> prefixCount = new HashMap<>();

        long prefixSum = 0;
        long count = 0;

        prefixCount.put(0L, 1); // 누적 합이 0인 경우를 위해 초기값 설정

        for (int i = 0; i < data.length; i++) {
            prefixSum += data[i];

            long complement = prefixSum - target; // 현재 누적 합에서 목표 합을 뺀 값이 이전에 등장한 적 있는지 확인

            if (prefixCount.containsKey(complement)) {
                count += prefixCount.get(complement);
            }

            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
