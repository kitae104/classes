package inhatc.cse.java.quiz2026.ex49;

import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 상
 * 조건부 map - 조건에 따라 값 변환
 */
public class Ex49ConditionalMap {
    
    static class Sale {
        int amount;
        
        public Sale(int amount) {
            this.amount = amount;
        }
        
        public int getAmount() {
            return amount;
        }
    }
    
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale(50000),
            new Sale(150000),
            new Sale(80000),
            new Sale(200000),
            new Sale(60000)
        );
        
        System.out.println("판매 기록:");
        sales.forEach(s -> System.out.println("  " + s.amount + "원"));
        
        // 100,000원 이상이면 판매액, 미만이면 0으로 변환
        int totalQualified = sales.stream()
                                   .mapToInt(s -> s.getAmount() >= 100000 ? s.getAmount() : 0)
                                   .sum();
        
        System.out.println("\n100,000원 이상인 판매액 합계: " + totalQualified + "원");
    }
}

