package inhatc.cse.java.quiz2026.ex44;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * 중첩 groupingBy - 2단계 그룹화
 */
public class Ex44NestedGroupingBy {
    
    static class Product {
        String name;
        String category;
        int price;
        
        public Product(String name, String category, int price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }
        
        public String getCategory() {
            return category;
        }
        
        public String getPriceRange() {
            if (price <= 500) return "저가";
            else if (price <= 1000) return "중가";
            else return "고가";
        }
        
        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1500),
            new Product("Phone", "Electronics", 800),
            new Product("Tablet", "Electronics", 500),
            new Product("Chair", "Furniture", 200),
            new Product("Table", "Furniture", 400)
        );
        
        System.out.println("원본 상품 리스트:");
        products.forEach(p -> System.out.println("  " + p));
        
        // 중첩 groupingBy로 카테고리 -> 가격대로 그룹화
        Map<String, Map<String, List<Product>>> grouped = products.stream()
                                                                    .collect(Collectors.groupingBy(Product::getCategory,
                                                                                                    Collectors.groupingBy(Product::getPriceRange)));
        
        System.out.println("\n카테고리별 > 가격대별 그룹화:");
        grouped.forEach((category, priceMap) -> {
            System.out.println("[" + category + "]");
            priceMap.forEach((priceRange, productList) -> {
                System.out.println("  " + priceRange + ":");
                productList.forEach(p -> System.out.println("    " + p));
            });
        });
    }
}

