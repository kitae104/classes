package inhatc.cse.java.final2026.aban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ================================================================
 *  A반 - 2세트 (학생 동아리) 정답 소스
 * ================================================================
 *  데이터: 학생(Student) - name(이름), club(동아리), score(점수), volunteer(봉사시간)
 *  2세트 성격: 개수(count) / 순위(sorted+limit) / 판정(match) / 요약통계(summaryStatistics)
 *
 */
public class Test2 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김하늘", "코딩", 92, 10),
                new Student("이준호", "코딩", 85, 4),
                new Student("박서영", "밴드", 78, 8),
                new Student("최민재", "밴드", 88, 6),
                new Student("정유진", "미술", 95, 12),
                new Student("강도현", "미술", 70, 5),
                new Student("윤지아", "코딩", 90, 7)
        );

        // 1번 : 점수 85점 이상 학생이 몇 명인지 센다 (count)
        System.out.println("== 점수 85점 이상 학생 수 ==");
        long count = students.stream()
                .filter(s -> s.getScore() >= 85)
                .count();
        System.out.println(count + "명");
        System.out.println();

        // 2번 : 점수가 높은 순서로 상위 3명을 "이름(점수점)" 형태로 출력 (sorted + limit)
        System.out.println("== 점수 상위 3명 ==");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .limit(3)
                .map(s -> s.getName() + "(" + s.getScore() + "점)")
                .forEach(System.out::println);
        System.out.println();

        // 3번 : 전체 학생 점수의 요약 통계 (mapToInt + summaryStatistics)
        System.out.println("== 전체 학생 점수 통계 ==");
        IntSummaryStatistics stats = students.stream()
                .mapToInt(Student::getScore)
                .summaryStatistics();
        System.out.println("인원 : " + stats.getCount() + "명");
        System.out.println("합계 : " + stats.getSum() + "점");
        System.out.println("최고 : " + stats.getMax() + "점");
        System.out.println("최저 : " + stats.getMin() + "점");
        System.out.println("평균 : " + String.format("%.1f", stats.getAverage()) + "점");
        System.out.println();

        // 4번 : 종합 - 봉사 6시간 이상 학생을 점수 내림차순 상위 3명 + 1위
        System.out.println("== 봉사시간 6시간 이상, 점수 상위 3명 ==");
        List<Student> top = students.stream()
                .filter(s -> s.getVolunteer() >= 6)
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .limit(3)
                .collect(Collectors.toList());
        top.stream()
                .map(s -> s.getName() + "(" + s.getScore() + "점)")
                .forEach(System.out::println);
        System.out.println("1위: " + top.get(0).getName());
    }
}
