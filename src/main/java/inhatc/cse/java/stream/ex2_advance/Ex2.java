package inhatc.cse.java.stream.ex2_advance;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Stream groupingBy
 *
 * 고객 목록을 도시(city) 기준으로 그룹화하고, 도시별 평균 나이를 구하세요.
 *
 * ## 데이터
 * - ("A", "Seoul", 20)
 * - ("B", "Seoul", 30)
 * - ("C", "Busan", 40)
 * - ("D", "Busan", 22)
 * - ("E", "Incheon", 28)
 *
 * ## 요구사항
 * - `Map<String, Double>` 형태로 만들고 도시명 오름차순으로 출력하세요.
 */
public class Ex2 {
    record Customer(String name, String city, int age) {

    }

    public static void main(String[] args) {
        List<Customer> customerList = List.of(
                new Customer("A", "Seoul", 20),
                new Customer("B", "Seoul", 30),
                new Customer("C", "Busan", 40),
                new Customer("D", "Busan", 22),
                new Customer("E", "Incheon", 28)
        );

//        TreeMap<String, Double> avgByCity = customerList.stream()
//                .collect(Collectors.groupingBy(
//                        Customer::city, // 그룹화 기준: 도시
//                        TreeMap::new, // 결과 맵 구현체: TreeMap (도시명 오름차순)
//                        Collectors.averagingInt(Customer::age) // 평균 나이 계산
//                ));

        TreeMap<String, Double> avgByCity = customerList.stream()
                .collect(Collectors.groupingBy(
                        customer -> customer.city,
                        () -> new TreeMap<>(),
                        Collectors.averagingInt(customer -> customer.age)
                ));
        avgByCity.forEach((city, avg) -> System.out.printf("%s = %.1f%n", city, avg));

    }
}
