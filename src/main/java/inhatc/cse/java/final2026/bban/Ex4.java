package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * B반 4번 (난이도: 중상)
 * groupingBy + summingInt(계산식) + entrySet 스트림 + sorted + forEach + max
 *
 * 고객별 총 결제금액(단가 x 수량의 합)을 구한 뒤,
 * 금액 내림차순으로 정렬하여 출력하고,
 * 마지막에 가장 많이 결제한 "VIP 고객"의 이름을 출력한다.
 */
public class Ex4 {

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

        // groupingBy(고객) + summingInt(단가 x 수량) 으로 고객별 총 결제금액 계산
        Map<String, Integer> totalByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingInt(o -> o.getPrice() * o.getQuantity())));

        System.out.println("== 고객별 총 결제금액 (내림차순) ==");
        totalByCustomer.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed())
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "원"));

        // 결제금액이 가장 큰 VIP 고객
        String vip = totalByCustomer.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("없음");

        System.out.println("VIP 고객: " + vip);
    }
}
