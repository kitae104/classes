package inhatc.cse.java.stream.ex1_basic;

import java.util.Comparator;
import java.util.List;

/**
 * 직원 목록을 급여 내림차순, 급여가 같으면 이름 오름차순으로 정렬해 출력하세요.
 *
 * 데이터
 * ("Kim", 4200, 3)
 * ("Lee", 5000, 5)
 * ("Park", 4200, 4)
 * ("Choi", 3800, 2)
 */
public class Ex6_sorted {
    record Employee(String name, int salary, int years) {
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Tim", 4200, 3),
                new Employee("Lee", 5000, 5),
                new Employee("Park", 4200, 4),
                new Employee("Choi", 3800, 2)
        );

        employees.stream()
                .sorted((e1, e2) -> e2.salary - e1.salary)
                .sorted((e1, e2) -> {
                    if (e1.salary == e2.salary) {
                        return e1.name.compareTo(e2.name); // 이름 오름차순
                    }
                    return 0; // 급여가 다르면 순서 유지
                })
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::salary)
                        .reversed()
                        .thenComparing(Employee::name))
                .forEach(System.out::println);

    }
}
