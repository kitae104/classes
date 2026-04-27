package inhatc.cse.java.quiz.b;

import java.util.List;

public class Ex5Answer {

    record Txn(String account, int amount) {
    }

    public static void main(String[] args) {
        List<Txn> txns = List.of(
                new Txn("A-1", 50000),
                new Txn("A-1", -12000),
                new Txn("B-1", -7000),
                new Txn("C-1", 10000),
                new Txn("A-1", -3000)
        );

        int expenseSum = txns.stream()
                .filter(txn -> txn.amount() < 0)
                .mapToInt(txn -> Math.abs(txn.amount()))
                .sum();

        System.out.println("expenseSum=" + expenseSum);
    }
}
