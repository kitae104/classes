package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * B반 3번 (난이도: 중)
 * groupingBy + counting + entrySet 스트림 + sorted(다중 정렬) + forEach
 *
 * 고객별 주문 "건수"를 구한 뒤,
 * 건수 내림차순(건수가 같으면 고객명 가나다순)으로 정렬하여 출력한다.
 */
public class Ex3 {

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

        // groupingBy(고객) + counting() 으로 고객별 주문 건수 계산
        Map<String, Long> countByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.counting()));

        System.out.println("== 고객별 주문 건수 (건수 내림차순, 동률은 고객명 가나다순) ==");
        countByCustomer.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed()
                                  .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "건"));
    }
}
