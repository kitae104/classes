package inhatc.cse.java.quiz2026.ex40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * 여러 Stream 메서드 조합 - filter + groupingBy + summingInt + sorted + limit
 */
public class Ex40ComprehensiveStream {

    static class Transaction {
        String customer;
        int amount;

        public Transaction(String customer, int amount) {
            this.customer = customer;
            this.amount = amount;
        }

        public String getCustomer() {
            return customer;
        }

        public int getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("Kim", 150000),
            new Transaction("Lee", 50000),
            new Transaction("Kim", 120000),
            new Transaction("Park", 200000),
            new Transaction("Lee", 80000),
            new Transaction("Choi", 110000)
        );

        System.out.println("원본 거래 리스트:");
        transactions.forEach(t -> System.out.println(t.customer + " : " + t.amount + "원"));

        // filter(100,000원 이상) -> groupingBy(고객) + summingInt(총액) -> entrySet로 변환 -> sorted(내림차순) -> limit(3)
        var topCustomers = transactions.stream()
                                        .filter(t -> t.getAmount() >= 100000)  // 100,000원 이상
                                        .collect(Collectors.groupingBy(Transaction::getCustomer,
                                                                        Collectors.summingInt(Transaction::getAmount)))
                                        .entrySet()
                                        .stream()
                                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))  // 내림차순
                                        .limit(3)  // 상위 3개
                                        .collect(Collectors.toList());

        System.out.println("\n100,000원 이상 거래, 고객별 총액 (상위 3명):");
        topCustomers.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue() + "원"));
    }
}

