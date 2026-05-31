# 2026년도 44번 - Stream groupingBy 다층 구조

상품(Product) 리스트를 카테고리별, 그 다음 가격대별로 그룹화하세요.

## 데이터
```java
new Product("Laptop", "Electronics", 1500)
new Product("Phone", "Electronics", 800)
new Product("Tablet", "Electronics", 500)
new Product("Chair", "Furniture", 200)
new Product("Table", "Furniture", 400)
```

## 요구사항
- `groupingBy()` 중첩으로 2단계 그룹화 (카테고리 -> 가격대)
- 가격대는 "저가(500 이하)", "중가(501~1000)", "고가(1001 이상)"
- 결과 출력

## 난이도: 상


