package inhatc.cse.java.quiz2026.ex29;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * Stream 객체 groupingBy - 객체의 속성으로 그룹화
 */
public class Ex29StreamObjectGrouping {
    
    // 간단한 Employee 클래스
    static class Employee {
        String id;
        String name;
        String department;
        
        public Employee(String id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
        
        public String getDepartment() {
            return department;
        }
        
        @Override
        public String toString() {
            return id + " - " + name;
        }
    }
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("A001", "Kim", "IT"),
            new Employee("A002", "Lee", "HR"),
            new Employee("A003", "Park", "IT"),
            new Employee("A004", "Choi", "Sales"),
            new Employee("A005", "Jung", "HR")
        );
        
        System.out.println("원본 직원 리스트:");
        employees.forEach(System.out::println);
        
        // groupingBy()로 부서별 그룹화
        Map<String, List<Employee>> byDepartment = employees.stream()
                                                             .collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println("\n부서별 직원:");
        byDepartment.forEach((dept, emps) -> {
            System.out.println("[" + dept + "]");
            emps.forEach(e -> System.out.println("  " + e));
        });
    }
}

