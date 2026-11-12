package inhatc.cse.java.stream.days;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 배송 데이터에서 완료된 배송만 선택하여 평균 배송 시간과 최대 배송 시간이 걸린 주문을 찾으시오.
 *
 * [요구 사항]
 * 1. stream()을 사용한다.
 * 2. filter()로 COMPLETED만 선택한다.
 * 3. teeing()을 반드시 사용한다.
 * 4. averagingInt()로 평균을 계산한다.
 * 5. maxBy()로 최대 배송 시간 주문을 찾는다.
 * 6. 결과를 DeliveryStats 레코드로 결합한다.
 * 7. Optional로 데이터가 없는 경우를 처리한다.
 * 8. for, while 반복문은 사용하지 않는다.
 * 9. 완료된 주문의 최대 배송 시간은 유일하다고 가정한다.
 */
record Delivery(
        String orderId,
        String status,
        int minutes
) {}

record DeliveryStats(
        double averageMinutes,
        Optional<Delivery> slowestDelivery
) {}

public class Day11 {
    public static void main(String[] args) {
        List<Delivery> deliveries = List.of(
                new Delivery("D001", "COMPLETED", 32),
                new Delivery("D002", "COMPLETED", 45),
                new Delivery("D003", "COMPLETED", 28),
                new Delivery("D004", "COMPLETED", 51),
                new Delivery("D005", "COMPLETED", 39),
                new Delivery("D006", "COMPLETED", 35),
                new Delivery("D007", "CANCELLED", 60)
        );

        // TODO 1. 완료된 배송만 필터링
        Stream<Delivery> completed = deliveries.stream()
                .filter(delivery -> delivery.status().equals("COMPLETED"));

        // TODO 2. teeing()으로 평균과 최대값 계산
        // TODO 3. DeliveryStats 객체 생성
        DeliveryStats stats = completed.collect(
                Collectors.teeing(
                        Collectors.averagingInt(Delivery::minutes),
                        Collectors.maxBy(
                                Comparator.comparingInt(Delivery::minutes)
                        ),
                        DeliveryStats::new
                )
        );

        // TODO 4. 평균 배송 시간 출력
        System.out.println("=== 배송 통계 ===");
        System.out.printf("%n평균 배송 시간 : %.2f분%n", stats.averageMinutes());

        // TODO 5. 최대 배송 시간 주문 출력
        stats.slowestDelivery().ifPresentOrElse(
                delivery -> {
                    System.out.println("\n가장 오래 걸린 배송");
                    System.out.println("주문번호: " + delivery.orderId());
                    System.out.println("배송 시간: " + delivery.minutes() + "분");
                },
                () -> System.out.println("\n완료된 배송이 없습니다.")
        );

    }
}
