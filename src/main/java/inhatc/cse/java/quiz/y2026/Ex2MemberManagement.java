package inhatc.cse.java.quiz.y2026;

import java.util.*;
import java.util.stream.Collectors;

public class Ex2MemberManagement {

    enum Role { USER, ADMIN, MANAGER }

    static class Member {
        private final String id;
        private final String name;
        private final int age;
        private final Role role;

        Member(String id, String name, int age, Role role) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.role = role;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public Role getRole() { return role; }

        @Override
        public String toString() {
            return String.format("Member{id='%s', name='%s', age=%d, role=%s}", id, name, age, role);
        }
    }

    // 내부 클래스: 나이 정렬용 Comparator (오름차순)
    private static class AgeComparator implements Comparator<Member> {
        @Override
        public int compare(Member m1, Member m2) {
            return Integer.compare(m1.getAge(), m2.getAge());
        }
    }

    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("user01", "김민재", 22, Role.USER),
                new Member("user02", "박서연", 19, Role.ADMIN),
                new Member("user03", "이도윤", 25, Role.MANAGER),
                new Member("user04", "최유진", 30, Role.USER),
                new Member("user01", "김민재", 22, Role.USER)
        );

        System.out.println("==== 원본 리스트 ====");
        members.forEach(System.out::println);

        // 1) 20세 이상 회원만 출력
        System.out.println("\n==== 1) 20세 이상 회원 ====");
        members.stream()
                .filter(m -> m.getAge() >= 20)
                .forEach(System.out::println);

        // 2) 역할이 ADMIN인 회원만 출력
        System.out.println("\n==== 2) Role == ADMIN ====");
        members.stream()
                .filter(m -> m.getRole() == Role.ADMIN)
                .forEach(System.out::println);

        // 3) 나이 기준 오름차순 정렬 (내부 클래스 AgeComparator 사용)
        System.out.println("\n==== 3) 나이 기준 오름차순 ====");
        members.stream()
                .sorted(new AgeComparator())
                .forEach(System.out::println);

        // 4) 역할별 회원 목록 출력
        System.out.println("\n==== 4) 역할별 회원 목록 ====");
        Map<Role, List<Member>> byRole = members.stream()
                .collect(Collectors.groupingBy(Member::getRole));
        for (Role r : Role.values()) {
            System.out.printf("%s : %s%n", r, byRole.getOrDefault(r, Collections.emptyList()));
        }

        // 5) 중복 회원 제거 (아이디 기준, 첫 등장 유지)
        System.out.println("\n==== 5) 중복 제거 (아이디 기준, 첫 등장 유지) ====");
        Map<String, Member> uniqueById = new LinkedHashMap<>();
        for (Member m : members) {
            uniqueById.putIfAbsent(m.getId(), m);
        }
        uniqueById.values().forEach(System.out::println);

        // 6) 이름이 가장 긴 회원 출력(여러명 있을 경우 첫 등장)
        System.out.println("\n==== 6) 이름이 가장 긴 회원 ====");
        members.stream()
                .max(Comparator.comparingInt(m -> m.getName().length()))
                .ifPresent(System.out::println);
    }
}

