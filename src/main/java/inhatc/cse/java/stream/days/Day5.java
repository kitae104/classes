package inhatc.cse.java.stream.days;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 상품별 최고 가격 찾기
 *
 * 요구사항
 * 1. stream()을 사용하세요.
 * 2. Collectors.toMap()을 이용하여 Map<String, Integer>를 생성하세요.
 * 3. 상품 이름을 Key로 사용하세요.
 * 4. 상품 가격을 Value로 사용하세요.
 * 5. 동일한 상품 이름이 여러 번 등장하면 가장 높은 가격을 선택하세요.
 * 6. 상품 이름을 알파벳 오름차순으로 출력하세요.
 * 7. for, while 반복문을 사용하지 마세요.
 */
public class Day5 {
    record Product(String name, int price) {
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Keyboard", 45000),
                new Product("Mouse", 25000),
                new Product("Monitor", 250000),
                new Product("Keyboard", 55000),
                new Product("Mouse", 30000),
                new Product("Monitor", 230000),
                new Product("Speaker", 70000)
        );

        // 상품 이름을 Key로, 상품 가격을 Value로 하는 Map 생성
        Map<String, Integer> productMap = products.stream()
                .collect(Collectors.toMap(
                        Product::name,
                        Product::price,
                        Integer::max
                ));
        System.out.println("상품 정보: " + productMap);

        // 상품 이름을 알파벳 오름차순으로 출력
        Map<String, Integer> sortedProductMap = productMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("정렬된 상품 정보: " + sortedProductMap);

        System.out.println("=== 상품별 최고 가격 ===");
        sortedProductMap.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("상품 종류 :" + productMap.size());

        // 상품 가격으로 내림차순 정렬
        Map<String, Integer> sortedByPriceMap = productMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("=== 상품별 최고 가격 (가격 내림차순) ===");
        sortedByPriceMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
