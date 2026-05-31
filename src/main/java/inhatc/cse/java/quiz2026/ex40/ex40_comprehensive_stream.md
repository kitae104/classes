# 2026년도 40번 - Stream 여러 메서드 조합 (종합)

거래 리스트에서 100,000원 이상인 거래만 선택하여 고객별로 그룹화하고, 각 고객별 총액을 구한 후, 내림차순으로 정렬하여 상위 3개를 출력하세요.

## 데이터
```java
new Transaction("Kim", 150000)
new Transaction("Lee", 50000)
new Transaction("Kim", 120000)
new Transaction("Park", 200000)
new Transaction("Lee", 80000)
new Transaction("Choi", 110000)
```

## 요구사항
- `filter()`로 100,000원 이상 선택
- `groupingBy()` + `summingInt()` 로 고객별 총액
- `sorted()` 내림차순
- `limit(3)` 상위 3개

## 난이도: 상


