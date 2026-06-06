package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.List;

/**
 * B반 1번 (난이도: 하)
 * filter + map + distinct + sorted + forEach
 *
 * 단가(price)가 5,000원 이상인 메뉴의 "이름"을 중복 없이,
 * 가나다순(오름차순)으로 정렬하여 출력한다.
 */
public class Ex1 {

    static class Order {
        String customer;
        String menu;
        String category;
        int price;     // 단가
        int quantity;  // 수량

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

        System.out.println("== 단가 5,000원 이상 메뉴 (중복제거, 가나다순) ==");
        orders.stream()
              .filter(o -> o.getPrice() >= 5000)
              .map(Order::getMenu)
              .distinct()
              .sorted()
              .forEach(System.out::println);
    }
}
