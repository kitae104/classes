package inhatc.cse.java.quiz.c;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex5Answer {

    record Order(int id, int amount) {
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(101, 12000),
                new Order(102, 8000),
                new Order(101, 5000),
                new Order(103, 3000),
                new Order(102, 2000)
        );

        Map<Integer, Integer> totalById = orders.stream()
                .collect(Collectors.toMap(
                        Order::id,
                        Order::amount,
                        Integer::sum,
                        TreeMap::new
                ));

        System.out.println(totalById);
    }
}
