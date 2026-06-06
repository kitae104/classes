package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.List;

/**
 * B반 2번 (난이도: 중하)
 * filter + mapToInt(계산식) + sum
 *
 * '커피' 카테고리 주문에 대해 결제금액(단가 x 수량)을 모두 더한
 * 총 매출을 계산하여 출력한다.
 */
public class Ex2 {

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

        // filter(커피) -> mapToInt(단가 x 수량) -> sum
        int total = orders.stream()
                          .filter(o -> o.getCategory().equals("커피"))
                          .mapToInt(o -> o.getPrice() * o.getQuantity())
                          .sum();

        System.out.println("== 커피 카테고리 총 매출 ==");
        System.out.println(total + "원");
    }
}
