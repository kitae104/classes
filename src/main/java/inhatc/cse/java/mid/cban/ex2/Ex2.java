package inhatc.cse.java.mid.cban.ex2;

import java.util.Arrays;
import java.util.List;

/*
countInRange(List<T> values, T min, T max) 제네릭 메서드를 작성하시오.

요구사항
T는 구현해야 한다.
min 이상 max 이하인 값의 개수를 반환하시오.(특정 범위에 포함된 원소 개수 구하기)
테스트 데이터: [3, 8, 15, 6, 2, 10], min = 5, max = 10
 */
public class Ex2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 8, 15, 6, 2, 10);

        int result = countInRange(numbers, 5, 10);

        System.out.println("범위 내 원소 개수: " + result);
    }

    private static <T extends Number> int countInRange(List<T> values, T min, T max) {
        int count = 0;
        for (T value : values) {
            if(value.doubleValue() >= min.doubleValue() && value.doubleValue() <= max.doubleValue()) {
                count++;
            }
        }
        return count;
    }
}
