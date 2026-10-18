package inhatc.cse.java.algorithm.days;

/**
 * 두 번째로 큰 숫자 찾기
 * 정수 배열에서 중복을 제외하고 두 번째로 큰 숫자를 찾는 프로그램을 작성하세요.
 * int[] data = {25, 12, 38, 38, 17, 42, 9, 42, 30};
 *
 * 요구사항
 * 1. for 반복문과 if 조건문을 사용합니다.
 * 2. Arrays.sort()를 사용하지 않습니다.
 * 3. 한 번의 순회로 해결해 봅니다.
 * 4. 가장 큰 값과 두 번째로 큰 서로 다른 값을 출력합니다.
 * 5. 서로 다른 숫자가 2개 미만인 경우도 처리합니다.
 */
public class Day1 {
    public static void main(String[] args) {
        int[] data = {25, 12, 38, 38, 17, 42, 9, 42, 30};

        int max1 = Integer.MIN_VALUE; // 가장 큰 값
        int max2 = Integer.MIN_VALUE; // 두 번째로 큰 값

        for (int num : data) {
            if (num > max1) {
                max2 = max1; // 이전 최대값을 두 번째로
                max1 = num;  // 새로운 최대값 갱신
            } else if (num > max2 && num < max1) {
                max2 = num; // 두 번째로 큰 값 갱신
            }
        }

        System.out.println("가장 큰 값: " + max1);
        System.out.println("두 번째로 큰 값: " + max2);
    }
}
