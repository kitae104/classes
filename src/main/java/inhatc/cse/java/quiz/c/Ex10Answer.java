package inhatc.cse.java.quiz.c;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex10Answer {

    record Menu(String name, String type, int calories, boolean vegetarian) {
    }

    public static void main(String[] args) {
        List<Menu> menus = List.of(
                new Menu("Salad", "VEG", 180, true),
                new Menu("Pizza", "FAST", 700, false),
                new Menu("Tofu", "VEG", 250, true),
                new Menu("Burger", "FAST", 850, false),
                new Menu("Soup", "KOREAN", 300, true)
        );

        List<String> vegetarianNames = menus.stream()
                .filter(Menu::vegetarian)
                .map(Menu::name)
                .sorted()
                .toList();

        Map<String, Integer> caloriesByType = menus.stream()
                .collect(Collectors.groupingBy(
                        Menu::type,
                        TreeMap::new,
                        Collectors.summingInt(Menu::calories)
                ));

        String maxCalorieMenu = menus.stream()
                .max(Comparator.comparingInt(Menu::calories))
                .map(Menu::name)
                .orElse("NONE");

        System.out.println("vegetarian=" + vegetarianNames);
        System.out.println("caloriesByType=" + caloriesByType);
        System.out.println("maxCalorieMenu=" + maxCalorieMenu);
    }
}
