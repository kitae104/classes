package inhatc.cse.java.quiz2026.ex28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * Stream 객체 정렬 - Comparator.comparingInt() 사용
 */
public class Ex28StreamObjectSort {
    
    // 간단한 Product 클래스
    static class Product {
        String name;
        int price;
        
        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
        
        public String getName() {
            return name;
        }
        
        public int getPrice() {
            return price;
        }
        
        @Override
        public String toString() {
            return name + " : " + price + "$";
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1500),
            new Product("Phone", 800),
            new Product("Tablet", 500),
            new Product("Monitor", 300)
        );
        
        System.out.println("원본 상품 리스트:");
        products.forEach(System.out::println);
        
        // sorted()와 Comparator.comparingInt()로 가격 오름차순 정렬
        List<Product> sorted = products.stream()
                                        .sorted(Comparator.comparingInt(Product::getPrice))  // 가격 오름차순
                                        .collect(Collectors.toList());
        
        System.out.println("\n가격 오름차순 정렬:");
        sorted.forEach(System.out::println);
    }
}

