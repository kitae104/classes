package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * B반 5번 (난이도: 상)
 * filter + groupingBy + summingInt(계산식) + entrySet 스트림 + sorted + limit + map + joining
 *
 * 수량(quantity)이 2개 이상인 주문만 대상으로,
 * 카테고리별 총 결제금액(단가 x 수량의 합)을 구한 뒤,
 * 금액 내림차순으로 정렬하여 상위 2개 카테고리를
 * "카테고리:금액원" 형식으로 " | " 로 이어 한 줄로 출력한다.
 */
public class Ex5 {

    static class Order {
        String customer;
        String menu;
        String category;
        int price;
        int quantity;

        public Order(String customer, String menu, String category, int price, int quantity) {
            this.customer = customer;
            this.menu = menu;
            this.category = category;
            this.price = price;
            this.quantity = quantity;
        }

        public String getCustomer() { return customer; }
        public String getMenu() { return menu; }
        public String getCategory() { return category; }
        public int getPrice() { return price; }
        public int getQuantity() { return quantity; }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("김민준", "아메리카노", "커피", 4500, 2),
            new Order("이서연", "카페라떼", "커피", 5000, 1),
            new Order("박도윤", "녹차라떼", "티", 5500, 3),
            new Order("최지우", "치즈케이크", "디저트", 6500, 1),
            new Order("김민준", "아메리카노", "커피", 4500, 1),
            new Order("정시우", "얼그레이", "티", 5000, 2),
            new Order("이서연", "티라미수", "디저트", 7000, 2),
            new Order("박도윤", "에스프레소", "커피", 4000, 1)
        );

        // 1. filter(수량 2개 이상) -> 2. groupingBy(카테고리) + summingInt(단가 x 수량)
        Map<String, Integer> totalByCategory = orders.stream()
                .filter(o -> o.getQuantity() >= 2)
                .collect(Collectors.groupingBy(Order::getCategory,
                        Collectors.summingInt(o -> o.getPrice() * o.getQuantity())));

        // 3. entrySet 스트림 -> sorted(금액 내림차순) -> limit(2) -> map(형식) -> joining
        String result = totalByCategory.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed())
                .limit(2)
                .map(e -> e.getKey() + ":" + e.getValue() + "원")
                .collect(Collectors.joining(" | "));

        System.out.println("== 수량 2개 이상 주문, 카테고리별 매출 상위 2개 ==");
        System.out.println(result);
    }
}
