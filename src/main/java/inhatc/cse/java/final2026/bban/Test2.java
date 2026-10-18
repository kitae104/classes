package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ================================================================
 *  B반 - 2세트 (식당 메뉴) 정답 소스
 * ================================================================
 *  데이터: 메뉴(Menu) - name(메뉴명), category(분류), price(가격), calorie(칼로리)
 *  2세트 성격: 합계(sum) / 그룹 개수(groupingBy+counting) / 분할(partitioningBy)
 *             / 요약통계(summaryStatistics) / 그룹 합계(summingInt)
 *             → 1세트(count/limit/match/joining) 와 겹치지 않는 메소드 사용
 */
public class Test2 {

    public static void main(String[] args) {
        List<Menu> menus = Arrays.asList(
                new Menu("비빔밥",   "한식", 9000, 600),
                new Menu("김치찌개", "한식", 8000, 450),
                new Menu("짜장면",   "중식", 7000, 800),
                new Menu("탕수육",   "중식", 15000, 1200),
                new Menu("초밥",     "일식", 13000, 500),
                new Menu("우동",     "일식", 8500, 550),
                new Menu("돈까스",   "일식", 10000, 950)
        );

        // 1번 : 전체 메뉴 가격 합계 (mapToInt + sum)
        System.out.println("== 전체 메뉴 가격 합계 ==");
        int total = menus.stream()
                .mapToInt(Menu::getPrice)
                .sum();
        System.out.println(total + "원");
        System.out.println();

        // 2번 : 분류별 메뉴 개수를 분류명 가나다순으로 출력 (groupingBy + counting)
        System.out.println("== 분류별 메뉴 개수 (분류명 가나다순) ==");
        Map<String, Long> countByCat = menus.stream()
                .collect(Collectors.groupingBy(Menu::getCategory, Collectors.counting()));
        countByCat.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "개"));
        System.out.println();

        // 3번 : 가격 10,000원 기준으로 두 그룹(이상/미만)으로 분할 (partitioningBy)
        System.out.println("== 가격 10,000원 기준 분할 ==");
        Map<Boolean, List<Menu>> part = menus.stream()
                .collect(Collectors.partitioningBy(m -> m.getPrice() >= 10000));
        System.out.println("[10,000원 이상]");
        part.get(true).forEach(m -> System.out.println("  " + m.getName()));
        System.out.println("[10,000원 미만]");
        part.get(false).forEach(m -> System.out.println("  " + m.getName()));
        System.out.println();

        // 4번 : 종합 - 가격 8,000원 이상 메뉴의 분류별 가격 합계를 내림차순 + 1위 (groupingBy + summingInt)
        System.out.println("== 가격 8,000원 이상, 분류별 가격 합계 (내림차순) ==");
        Map<String, Integer> sumByCat = menus.stream()
                .filter(m -> m.getPrice() >= 8000)
                .collect(Collectors.groupingBy(Menu::getCategory, Collectors.summingInt(Menu::getPrice)));
        List<Map.Entry<String, Integer>> ranked = sumByCat.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer> e) -> e.getValue()).reversed())
                .collect(Collectors.toList());
        ranked.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "원"));
        System.out.println("가격 합계 1위 분류: " + ranked.get(0).getKey());
    }
}
