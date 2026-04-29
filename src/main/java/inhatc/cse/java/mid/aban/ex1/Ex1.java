package inhatc.cse.java.mid.aban.ex1;

import java.util.List;

/*
sumNumbers(List<? extends Number>) 메서드를 작성해 숫자 리스트 합계를 double로 반환하세요.

테스트
[1, 2, 3, 4]
[1.5, 2.0, 3.5]
 */
public class Ex1 {
    public static void main(String[] args) {
        System.out.println(sumNumbers(List.of(1, 2, 3, 4)));
        System.out.println(sumNumbers(List.of(1.5, 2.0, 3.5)));
    }

    private static double sumNumbers(List<? extends Number> numbers) {
        double sum = numbers.stream()
                .mapToDouble(x -> x.doubleValue())
                .sum();
        return sum;
    }


}
