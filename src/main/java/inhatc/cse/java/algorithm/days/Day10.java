package inhatc.cse.java.algorithm.days;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 */
public class Day10 {
    public static void main(String[] args) {

        int[] data = {4, 5, 2, 10, 8, 10, 3};

        int[] result = nextGreaterElements(data);

        System.out.println("원본 배열: " + Arrays.toString(data));

        System.out.println("다음 큰 수: " + Arrays.toString(result));
    }

    public static int[] nextGreaterElements(int[] data) {

        int n = data.length;

        int[] result = new int[n];

        Deque stack = new ArrayDeque<>();

        // TODO 1. result를 -1로 초기화
        Arrays.fill(result, -1);

        // TODO 2. 오른쪽에서 왼쪽으로 순회
        for (int i = n-1; i >= 0; i--) {

            // TODO 3. 현재 값보다 작거나 같은 값 제거
            while(!stack.isEmpty() && (int)stack.peek() <= data[i]){
                stack.pop();
            }

            // TODO 4. 다음 큰 수 확인
            if(!stack.isEmpty()){
                result[i] = (int)stack.peek();
            }

            // TODO 5. 현재 값 스택에 저장
            stack.push(data[i]);
        }

        return result;
    }
}