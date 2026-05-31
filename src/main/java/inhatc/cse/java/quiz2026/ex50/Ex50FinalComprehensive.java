package inhatc.cse.java.quiz2026.ex50;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * 최종 종합 실습 - filter + map + sorted + limit + joining 모두 사용
 */
public class Ex50FinalComprehensive {

    static class Member {
        String name;
        int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Kim", 25),
            new Member("Lee", 17),
            new Member("Park", 30),
            new Member("Choi", 20),
            new Member("Jung", 16),
            new Member("Kang", 28)
        );

        System.out.println("원본 회원 리스트:");
        members.forEach(m -> System.out.println("  " + m.name + " (" + m.age + "세)"));

        // 1. filter(나이 18 이상) -> 2. sorted(이름 오름차순) -> 3. limit(5)
        // 4. map(형식 변환) -> 5. joining(", ")
        String result = members.stream()
                               .filter(m -> m.getAge() >= 18)  // 18세 이상만
                               .sorted(Comparator.comparing(Member::getName))  // 이름 오름차순
                               .limit(5)  // 최대 5명
                               .map(m -> m.getName() + "(" + m.getAge() + ")")  // "이름(나이)" 형식
                               .collect(Collectors.joining(", "));  // 쉼표로 구분

        System.out.println("\n처리 결과:");
        System.out.println(result);
    }
}


