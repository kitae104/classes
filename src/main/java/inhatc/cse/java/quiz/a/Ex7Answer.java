package inhatc.cse.java.quiz.a;

import java.util.List;

public class Ex7Answer {

    record Item(String name, String category, int price) {
    }

    public static void main(String[] args) {
        List<Item> items = List.of(
                new Item("Java Basic", "BOOK", 18000),
                new Item("Keyboard", "DEVICE", 45000),
                new Item("Stream Guide", "BOOK", 22000),
                new Item("Mouse", "DEVICE", 25000)
        );

        int sum = items.stream()
                .filter(item -> item.category().equals("BOOK"))
                .mapToInt(Item::price)
                .sum();

        System.out.println("bookSum=" + sum);
    }
}
