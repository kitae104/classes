package inhatc.cse.java.stream.days;
/**
 * 상품 판매 데이터에서 카테고리별 매출 통계를 계산하시오.
 *
 * [요구사항]
 * 1. stream()을 사용한다.
 * 2. groupingBy()를 사용한다.
 * 3. summarizingInt()를 사용한다.
 * 4. 카테고리별 매출 통계를 생성한다.
 * 5. 결과는 IntSummaryStatistics에 저장한다.
 * 6. 카테고리는 알파벳순으로 출력한다.
 * 7. 평균은 소수점 둘째 자리까지 출력한다.
 * 8. for, while 반복문은 사용하지 않는다.
 * 9. 상품별 매출과 합계는 int 범위 이내라고 가정한다.
 */

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Sale(
        String category,
        String name,
        int price,
        int quantity
) {}

public class Day9 {
    public static void main(String[] args) {

        List<Sale> sales = List.of(
                new Sale("Book", "Java", 12000, 2),
                new Sale("Electronics", "Mouse", 45000, 1),
                new Sale("Book", "Python", 8000, 3),
                new Sale("Food", "Coffee", 5000, 4),
                new Sale("Electronics", "Keyboard", 30000, 2),
                new Sale("Food", "Juice", 7000, 1),
                new Sale("Book", "Spring", 15000, 1)
        );

        // TODO 1. groupingBy()로 카테고리 분류
        Map<String, List<Sale>> categoryMap = sales.stream()
                .collect(Collectors.groupingBy(Sale::category));
        System.out.println("categoryMap = " + categoryMap);
        System.out.println("==============================");
        System.out.println();

        // TODO 2. summarizingInt()로 통계 계산
        categoryMap.forEach((category, list) -> {
            IntSummaryStatistics stats = list.stream()
                    .collect(Collectors.summarizingInt(sale -> sale.price() * sale.quantity()));
            System.out.println("[" + category + "]");
            System.out.println("판매 기록 수 : " + stats.getCount() + "건");
            System.out.println("총 매출 : " + stats.getSum() + "원");
            System.out.printf("평균 매출 : %.2f원%n", stats.getAverage());
            System.out.println("최소 매출 : " + stats.getMin() + "원");
            System.out.println("최대 매출 : " + stats.getMax() + "원");
            System.out.println();

        });
        System.out.println("==============================");

        // TODO 3. groupingBy()와 summarizingInt()를 한 번에 사용
        Map<String, IntSummaryStatistics> categoryStats = sales.stream()
                .collect(Collectors.groupingBy(Sale::category,
                        Collectors.summarizingInt(sale -> sale.price() * sale.quantity())));

        categoryStats.forEach((category, stats) -> {
            System.out.println("[" + category + "]");
            System.out.println("판매 기록 수 : " + stats.getCount() + "건");
            System.out.println("총 매출 : " + stats.getSum() + "원");
            System.out.printf("평균 매출 : %.2f원%n", stats.getAverage());
            System.out.println("최소 매출 : " + stats.getMin() + "원");
            System.out.println("최대 매출 : " + stats.getMax() + "원");
            System.out.println();
        });

    }
}
