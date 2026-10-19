package inhatc.cse.java.algorithm.days;

/**
 * 배열에서 두 수의 합이 특정 값이 되는 쌍 찾기
 *
 * 요구사항
 * 1. for 또는 while 반복문을 사용합니다.
 * 2. 두 개의 포인터(left, right)를 사용합니다.
 * 3. 배열은 이미 오름차순으로 정렬되어 있다고 가정합니다.
 * 4. 두 숫자의 합계가 목표값과 같으면 출력합니다.
 * 5. 동일한 값으로 구성된 숫자 쌍은 중복 출력하지 않습니다.
 * 6. 시간 복잡도 O(n)으로 구현합니다.
 * 7. stream()과 이중 반복문은 사용하지 않습니다.
 */
public class Day4 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 7, 9, 11};
        int target = 12;

        int left = 0;
        int right = data.length - 1;
        int count = 0;
        while (left <= right) {
            int sum = data[left] + data[right];

            if(sum == target) {
                System.out.println("(" + data[left] + ", " + data[right] + ")");
                left++;
                right--;
                count++;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("총 " + count + "개의 쌍이 발견되었습니다.");
    }
}
