package inhatc.cse.java.algorithm.days;

import java.util.Arrays;

/**
 * 재귀를 이용한 최대공약수 계산
 * <p>
 * 요구사항
 * <p>
 * 1. gcd(int a, int b) 메서드를 작성하세요.
 * 2. gcd() 메서드는 반드시 재귀 호출을 사용해야 합니다.
 * 3. 유클리드 호제법을 적용하세요.
 * 4. 배열 전체의 최대공약수를 계산하는 arrayGcd() 메서드를 작성하세요.
 * 5. arrayGcd()에서는 반복문을 사용할 수 있습니다.
 * 6. BigInteger.gcd()는 사용하지 마세요.
 * 7. 입력 배열에는 1개 이상의 양의 정수가 들어 있다고 가정합니다.
 * 8. 두 수의 최대공약수 계산은 O(log(min(a, b))) 시간 복잡도를 목표로 합니다.
 */
public class Day7 {
    public static void main(String[] args) {

        int[][] testCases = {
                {48, 72, 120, 96},
                {15, 25, 35, 45},
                {7, 11, 13, 17}
        };

        for (int[] data : testCases) {
            int result = arrayGcd(data);

            System.out.println("배열: " + Arrays.toString(data));

            System.out.println("최대공약수: " + result);

            System.out.println();
        }
    }

    // 두 숫자의 최대공약수
    public static int gcd(int a, int b) {

        // TODO 1. 재귀 종료 조건 작성
        if (b == 0) {
            return a;
        }

        // TODO 2. 유클리드 호제법을 이용한 재귀 호출
        return gcd(b, a % b);
    }

    // 배열 전체의 최대공약수
    public static int arrayGcd(int[] data) {

        // TODO 3. 첫 번째 숫자를 초기 최대공약수로 설정
        int result = data[0];

        // TODO 4. 배열의 두 번째 숫자부터 순회
        for (int i = 1; i < data.length; i++) {
            // TODO 5. gcd() 메서드를 호출하여 결과 갱신
            result = gcd(result, data[i]);
        }
        return result;
    }
}
