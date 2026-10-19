package inhatc.cse.java.stream.days;

import java.util.List;

/**
 * 중첩 리스트에서 기술 목록 추출
 */
public class Day4 {
    public static void main(String[] args) {
        List<List<String>> teamSkills = List.of(
                List.of("Java", "Spring", "SQL"),
                List.of("Python", "Java", "Docker"),
                List.of("Git", "Spring", "Kotlin", "React")
        );
        System.out.println("중첩 리스트: " + teamSkills);
        System.out.println();


        // TODO 1. 중첩 리스트를 하나의 스트림으로 변환
        List<String> flatList = teamSkills.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println("하나의 리스트로 변환: " + flatList);
        System.out.println();

        // TODO 2. 길이가 5 이상인 기술만 선택
        List<String> longSkillList = flatList.stream()
                .filter(skill -> skill.length() >= 5)
                .toList();
        System.out.println("길이가 5 이상인 기술만: " + longSkillList);
        System.out.println();

        // TODO 3. 중복 제거
        List<String> distinctList = longSkillList.stream()
                .distinct()
                .toList();
        System.out.println("중복 제거: " + distinctList);
        System.out.println();

        // TODO 4. 오름차순 정렬
        List<String> sortedList = distinctList.stream()
                .sorted()
                .toList();
        System.out.println("오름차순 정렬: " + sortedList);
        System.out.println();

        // 기술 개수
        long count = sortedList.stream()
                 .count();
        System.out.println("기술 개수: " + count);

    }
}
