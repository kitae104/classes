package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ================================================================
 *  A반 - 1세트 (과일 가게) 정답 소스
 * ================================================================
 *  공통 데이터: 과일(Fruit) 리스트
 *  - name(이름), category(분류), price(가격, 원), stock(재고, 개)
 *  모든 문제는 Stream API 로만 풀이한다.
 */
public class Test1 {

    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("딸기",     "베리류", 8000, 12),
                new Fruit("블루베리", "베리류", 15000, 6),
                new Fruit("오렌지",   "감귤류", 5000, 20),
                new Fruit("한라봉",   "감귤류", 12000, 8),
                new Fruit("망고",     "열대",   9000, 15),
                new Fruit("바나나",   "열대",   4000, 30),
                new Fruit("파인애플", "열대",   7000, 5)
        );

        // 1번 : 가격 8,000원 이상 과일 이름을 가나다순으로 출력
        //   filter(조건) -> map(이름) -> sorted -> forEach
        System.out.println("== 1번  8,000원 이상 과일 (이름 가나다순) ==");
        fruits.stream()
                .filter(f -> f.getPrice() >= 8000)
                .map(Fruit::getName)
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // 2번 : "열대" 분류를 가격 내림차순으로 "이름 - 가격원" 형태 출력
        System.out.println("== 2번 열대 과일 (가격 내림차순) ==");
        fruits.stream()
                .filter(f -> f.getCategory().equals("열대"))
                .sorted(Comparator.comparingInt(Fruit::getPrice).reversed())
                .map(f -> f.getName() + " - " + f.getPrice() + "원")
                .forEach(System.out::println);
        System.out.println();

        // 3번  : 가격 8,000원 기준으로 두 그룹(이상/미만)으로 분할
        //   partitioningBy 사용, 그룹 내부 순서는 원본 순서 유지
        System.out.println("== 3번 가격 8,000원 기준 분할 ==");
        Map<Boolean, List<Fruit>> partitioned = fruits.stream()
                .collect(Collectors.partitioningBy(f -> f.getPrice() >= 8000));
        System.out.println("[8,000원 이상]");
        partitioned.get(true).forEach(f -> System.out.println("  " + f.getName()));
        System.out.println("[8,000원 미만]");
        partitioned.get(false).forEach(f -> System.out.println("  " + f.getName()));
        System.out.println();

        // 4번 : 분류별 과일 종류 수 집계 -> 개수 내림차순, 동률은 분류명 가나다순
        System.out.println("== 4번 분류별 과일 종류 수 (개수 내림차순, 동률은 분류명 오름차순) ==");
        Map<String, Long> countByCategory = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getCategory, Collectors.counting()));
        countByCategory.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "종"));
        System.out.println();

    }
}
