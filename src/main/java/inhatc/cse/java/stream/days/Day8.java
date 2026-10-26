package inhatc.cse.java.stream.days;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors.partitioningBy()를 이용한 합격자 분류
 *
 * (1) 문제 설명
 * 학생들의 시험 점수가 저장된 리스트가 있다.
 * 70점 이상인 학생은 합격, 70점 미만인 학생은 불합격으로 분류하는 프로그램을 작성하시오.
 * 합격자와 불합격자의 인원수, 평균 점수, 전체 합격률을계산해야 한다.
 *
 * (2) 요구사항
 * 1. stream()을 사용한다.
 * 2. Collectors.partitioningBy()를 사용한다.
 * 3. 합격 기준은 70점 이상이다.
 * 4. 합격자와 불합격자를 각각 출력한다.
 * 5. 그룹별 인원수를 계산한다.
 * 6. 그룹별 평균 점수를 계산한다.
 * 7. 전체 합격률을 계산한다.
 * 8. 평균과 합격률은 소수점 둘째 자리까지 출력한다.
 * 9. 일반 for, while 반복문은 사용하지 않는다.
 * 10. 빈 그룹의 평균도 안전하게 처리한다.
 */

record Student(String name, int score) {}

public class Day8 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 95),
                new Student("Lee", 62),
                new Student("Park", 78),
                new Student("Choi", 55),
                new Student("Jung", 88),
                new Student("Han", 70),
                new Student("Kang", 49),
                new Student("Yoon", 83)
        );

        int passScore = 70; // 합격 기준 점수

        // TODO 1. partitioningBy()를 이용한 그룹 분할
        Map<Boolean, List<Student>> result = students.stream()
                .collect(Collectors.partitioningBy(student -> student.score() >= passScore));
        System.out.println(result); // true / false 로 구분


        // TODO 2. 합격자 추출
        List<Student> passed = result.get(true); // 합격자 추출
        System.out.println("합격자: " + passed);
        System.out.println();

        // TODO 3. 불합격자 추출
        List<Student> failed = result.get(false); // 불합격자 추출
        System.out.println("불합격자: " + failed);

        System.out.println("=== 시험 결과 ===");
        // TODO 4. 그룹별 학생 출력
        System.out.println("\n[합격자]");
        passed.forEach(student -> System.out.println(student.name() + " : " + student.score() + "점"));
        System.out.println();
        System.out.println("합격 인원 : " + passed.size() + "명");
        double passAverage = passed.stream()
                .mapToInt(Student::score)
                .sum() / (double) passed.size();

        System.out.println("합격자 평균 : " + String.format("%.2f", passAverage) + "점");

        System.out.println();
        System.out.println("[불합격자]");
        failed.forEach(student -> System.out.println(student.name() + " : " + student.score() + "점"));

        System.out.println("불합격자 인원 : " + failed.size() + "명");

        double failAverage = failed.stream()
                .mapToInt(Student::score)
                .sum() / (double) failed.size();

        System.out.println("불합격자 평균 : " + String.format("%.2f", failAverage) + "점");

        // TODO 5. 전체 합격률 계산
        System.out.println("\n전체 인원 : " + students.size() + "명");
        double passRate = (passed.size() / (double) students.size()) * 100;
        System.out.println("전체 합격률 : " + String.format("%.2f", passRate) + "%");


    }
}
