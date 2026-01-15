package kim.kitae.chap13.stream.ex2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterTest {

    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0; // 양수인지 검사하는 Predicate

        List<Integer> numbers = Arrays.asList(5, -10, -22, 0, 43, 7);
        Stream<Integer> s = numbers.stream().filter(isPositive);
        s.forEach(n -> System.out.println(n));

        System.out.println("-------------------");
        
        // 이미 사용된 스트림은 재사용 불가
        s = numbers.stream().filter(isPositive);
        s.forEach(System.out::println); // 위와 동일(메서드 참조)
    }
}
