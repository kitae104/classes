package inhatc.cse.java.stream.days;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 직원 목록에서 부서별 직원 이름을 수집하시오.
 * 동일 부서에서 이름이 중복되는 경우 한 번만 저장하고, 알파벳 오름차순으로 정렬한다.
 * 최종 이름 목록은 불변 리스트로 생성해야 한다.
 * <p>
 * [요구사항]
 * 1. stream()을 사용한다.
 * 2. groupingBy()로 부서별 그룹화한다.
 * 3. mapping()으로 이름을 추출한다.
 * 4. 중복된 이름을 제거한다.
 * 5. 알파벳 오름차순으로 정렬한다.
 * 6. collectingAndThen()을 반드시 사용한다.
 * 7. 각 부서의 이름 목록은 수정할 수 없어야 한다.
 * 8. 전체 부서 수와 중복 제외 직원 수를 출력한다.
 * 9. 일반 for, while은 사용하지 않는다.
 */

record Employee(String name, String department) {
}

public class Day10 {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Kim", "Backend"),
                new Employee("Lee", "Frontend"),
                new Employee("Park", "Backend"),
                new Employee("Choi", "Data"),
                new Employee("Han", "Frontend"),
                new Employee("Kim", "Backend"),
                new Employee("Jung", "Data"),
                new Employee("Yoon", "Backend")
        );

        // TODO 1. 부서별 그룹화
        Map<String, List<Employee>> deptMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        TreeMap::new,
                        Collectors.toList()));
        System.out.println("deptMap = " + deptMap);

        // TODO 2. mapping()으로 이름 추출
        Map<String, List<String>> deptNameMap = new TreeMap<>();

        deptMap.forEach((department, employeeList) -> {
            List<String> names = employeeList.stream()
                    .collect(Collectors.mapping(
                            Employee::name,
                            Collectors.toList()
                    ));
            deptNameMap.put(department, names);
        });
        System.out.println("\ndeptNameMap = " + deptNameMap);

        // TODO 3. 중복 제거
        deptNameMap.replaceAll((department, names) -> names.stream()
                .distinct()
                .collect(Collectors.toList()));
        System.out.println("\n중복 제거 후 deptNameMap = " + deptNameMap);


        // TODO 4. 정렬
        deptNameMap.replaceAll((department, names) -> names.stream()
                .sorted()
                .collect(Collectors.toList()));
        System.out.println("\n정렬 후 deptNameMap = " + deptNameMap);

        // TODO 5. collectingAndThen()으로 불변 리스트 생성
        Map<String, List<String>> result = new TreeMap<>();

        deptNameMap.forEach((department, names) -> {
            List<String> unmodifiableNames = names.stream()
                    .collect(Collectors.collectingAndThen(
                            Collectors.toList(),
                            List::copyOf
                    ));
            result.put(department, unmodifiableNames);
        });

        System.out.println("\n최종 결과 result = " + result);

        // TODO 6. 부서별 직원 목록 출력
        System.out.println("\n=== 부서별 직원 목록 ===");
        result.forEach((department, names) -> {
            System.out.println("[" + department + "]");
                    System.out.println("직원 : " + names);
                    System.out.println("직원 수 : " + names.size() + "명");
                });

        // TODO 7. 전체 부서 수 출력

        // TODO 8. 전체 직원 수 계산
    }
}
