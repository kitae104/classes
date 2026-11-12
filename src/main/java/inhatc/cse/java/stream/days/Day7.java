package inhatc.cse.java.stream.days;


import java.util.List;

/**
 * reduce()를 이용한 주문 금액 계산
 * <p>
 * 요구사항
 * 1. stream()을 사용하여 주문 데이터를 처리하세요.
 * 2. map()을 이용하여 각 주문의 금액(price × quantity)을 계산하세요.
 * 3. reduce()를 이용하여 전체 주문 금액을 합산하세요.
 * 4. 주문 금액이 100,000원 이상인 상품만 filter()로 추출하세요.
 * 5. 해당 상품에는 주문 금액의 10%를 할인 적용하세요.
 * 6. 할인된 주문 금액을 다시 reduce()로 합산하세요.
 * 7. sum()과 일반 for, while 반복문은 사용하지 마세요.
 * 8. 모든 금액은 정수로 계산하며, 입력된 단가와 수량은 양수이고 계산 결과는 int 범위를 초과하지 않는다고 가정합니다.
 * 9. 할인은 주문별로 적용하며, 100,000원 미만인 주문에는 할인을 적용하지 않습니다.
 */
public class Day7 {

    record Order(String name, int price, int quantity) {
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Keyboard", 50000, 2),
                new Order("Mouse", 30000, 3),
                new Order("Monitor", 250000, 1),
                new Order("USB", 15000, 4),
                new Order("Speaker", 80000, 2)
        );

        // 주문별 금액 계산
        System.out.println("=== 주문별 금액 ===");
        orders.forEach(order -> System.out.println(order.name() + " : " + (order.price() * order.quantity()) + "원"));

        // map()를 이용하여 각 주문의 금액(price × quantity)을 계산하고, reduce()를 이용하여 전체 주문 금액을 합산
        Integer totalMoney = orders.stream()
                .map(order -> order.price() * order.quantity())
                .reduce(0, (total, amount) -> total + amount);
        System.out.println("\n전체 주문 금액: " + totalMoney);

        // 주문 금액이 100,000원 이상인 상품만 filter()로 추출하고, 해당 상품에는 주문 금액의 10%를 할인 적용 후 reduce()로 합산
        List<Order> discountList = orders.stream()
                .filter(order -> order.price() * order.quantity() >= 100000)
                .toList();

        System.out.println("\n=== 할인 대상 상품 ===");
        discountList.forEach(item -> System.out.println(item.name() + " : " + (item.price() * item.quantity()) + "원"));

        // 할인 대상 금액 합계 
        Integer totalDiscountedMoney = discountList.stream()
                .map(item -> item.price() * item.quantity())
                .reduce(0, Integer::sum);

        // 주문별 10% 할인 금액 합산 
        Integer totalDiscount = discountList.stream()
                .map(item -> (item.price() * item.quantity()) / 10)
                .reduce(0, Integer::sum);

        // 전체 주문의 할인 적용 후 금액 합산
        Integer finalMoney = orders.stream()
                .map(order -> {
                    int amount = order.price() * order.quantity();
                    return amount >= 100000 ? amount - (amount / 10) : amount;
                })
                .reduce(0, Integer::sum);


        System.out.println("할인 대상 금액: " + totalDiscountedMoney + "원");
        System.out.println("총 할인 금액: " + totalDiscount + "원");
        System.out.println("할인 적용 후 금액: " + finalMoney + "원");

    }
}
