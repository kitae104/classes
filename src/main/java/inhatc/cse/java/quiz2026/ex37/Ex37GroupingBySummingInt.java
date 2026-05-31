package inhatc.cse.java.quiz2026.ex37;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * groupingBy + summingInt - 그룹별 합계 계산
 */
public class Ex37GroupingBySummingInt {
    
    static class Order {
        String customer;
        int amount;
        
        public Order(String customer, int amount) {
            this.customer = customer;
            this.amount = amount;
        }
        
        public String getCustomer() {
            return customer;
        }
        
        public int getAmount() {
            return amount;
        }
        
        @Override
        public String toString() {
            return customer + " - " + amount + "원";
        }
    }
    
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Kim", 50000),
            new Order("Lee", 30000),
            new Order("Kim", 20000),
            new Order("Park", 60000),
            new Order("Lee", 40000)
        );
        
        System.out.println("원본 주문 리스트:");
        orders.forEach(System.out::println);
        
        // groupingBy + summingInt로 고객별 총 주문액 계산
        Map<String, Integer> totalByCustomer = orders.stream()
                                                      .collect(Collectors.groupingBy(Order::getCustomer, 
                                                                                      Collectors.summingInt(Order::getAmount)));
        
        System.out.println("\n고객별 총 주문액:");
        totalByCustomer.forEach((customer, total) -> System.out.println(customer + " : " + total + "원"));
    }
}

