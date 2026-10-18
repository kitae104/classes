package inhatc.cse.java.final2026.bban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ================================================================
 *  B반 - 1세트 (동물원 동물) 정답 소스
 * ================================================================
 *  데이터: 동물(Animal) - name(이름), type(분류), age(나이), weight(몸무게)
 *  B반 성격: 개수(count) / 순위(sorted+limit) / 판정(match) / 극값 중심 (그룹 집계 미사용)
 */
public class Test1 {

    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Animal("사자",   "포유류", 8, 190),
                new Animal("코끼리", "포유류", 15, 5000),
                new Animal("펭귄",   "조류",   5, 30),
                new Animal("독수리", "조류",   10, 6),
                new Animal("거북이", "파충류", 30, 120),
                new Animal("악어",   "파충류", 12, 200),
                new Animal("기린",   "포유류", 7, 800)
        );

        // 1번 : 나이 10살 이상 20살 이하 동물이 몇 마리인지 센다 (count)
        System.out.println("== 나이 10살 이상 20살 이하 동물 수 ==");
        long count = animals.stream()
                .filter(a -> a.getAge() >= 10 &&  a.getAge() <= 20)
                .count();
        System.out.println(count + "마리");
        System.out.println();

        // 2번 : 몸무게가 무거운 순서로 상위 3마리를 "이름(몸무게kg)" 형태로 출력 (sorted + limit)
        System.out.println("== 몸무게 상위 3마리 ==");
        animals.stream()
                .sorted(Comparator.comparingInt(Animal::getWeight).reversed())
                .limit(3)
                .map(a -> a.getName() + "(" + a.getWeight() + "kg)")
                .forEach(System.out::println);
        System.out.println();

        // 3번 : 세 가지 조건을 판정한다 (allMatch / anyMatch / noneMatch)
        System.out.println("== 조건 판정 ==");
        boolean allHeavy = animals.stream().allMatch(a -> a.getWeight() >= 100);
        boolean anyOld   = animals.stream().anyMatch(a -> a.getAge() >= 25);
        boolean noneHuge = animals.stream().noneMatch(a -> a.getWeight() >= 6000);
        System.out.println("모든 동물의 몸무게가 100kg 이상인가? " + (allHeavy ? "예" : "아니오"));
        System.out.println("나이 25살 이상 동물이 있는가? " + (anyOld ? "예" : "아니오"));
        System.out.println();

        // 4번 : 가장 무거운 동물과 가장 가벼운 동물의 이름 (sorted + findFirst)
        System.out.println("== 몸무게 극값 동물 ==");
        String heaviest = animals.stream()
                .sorted(Comparator.comparingInt(Animal::getWeight).reversed())
                .findFirst().get().getName();
        String lightest = animals.stream()
                .sorted(Comparator.comparingInt(Animal::getWeight))
                .findFirst().get().getName();
        System.out.println("가장 무거운 동물: " + heaviest);
        System.out.println("가장 가벼운 동물: " + lightest);
        System.out.println();
    }
}
