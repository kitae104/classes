package inhatc.cse.java.mid.aban.ex1;

import java.util.List;

/*
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
        return numbers.stream()
                .mapToDouble(x -> x.doubleValue())
                .sum();
    }

}
