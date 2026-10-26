package inhatc.cse.java.algorithm.days;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 이진 탐색
 *
 * 요구사항
 * 1. while 반복문을 사용하세요.
 * 2. left, right, mid 변수를 사용하세요.
 * 3. 가운데 값을 기준으로 탐색 범위를 줄이세요.
 * 4. 목표값을 찾으면 해당 인덱스를 반환하세요.
 * 5. 목표값이 없으면 -1을 반환하세요.
 * 6. Arrays.binarySearch()는 사용하지 마세요.
 * 7. 시간 복잡도 **O(log n)**으로 구현하세요.
 */
public class Day5 {
    public static void main(String[] args) {
        int[] data = {3, 7, 12, 18, 25, 31, 42, 56, 68, 79, 91};
        int target = 42;

        int left = 0;
        int right = data.length - 1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(data[mid] == target){
                index = mid;
                break;
            } else if(data[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Index: " + index);

        // 정수 배열의 경우 Arrays.binarySearch()를 사용하여 이진 탐색 수행
        int i = Arrays.binarySearch(data, target);
        System.out.println("Index (using Arrays.binarySearch): " + i);

        // 정수 배열을 List<Integer>로 변환 후 Collections.binarySearch() 사용
        int j = Collections.binarySearch(Arrays.stream(data).boxed().toList(), target);
        System.out.println("Index (using Collections.binarySearch): " + j);
    }
}
