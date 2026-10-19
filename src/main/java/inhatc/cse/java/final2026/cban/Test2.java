package inhatc.cse.java.final2026.cban;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * ================================================================
 *  C반 - 2세트 (자동차) 정답 소스
 * ================================================================
 *  데이터: 자동차(Car) - name(차종), maker(제조사), price(가격, 만원), efficiency(연비, km/L)
 *  2세트 성격: 개수(count) / 순위(sorted+limit) / 맵 변환(toMap) / 극값(max·min+Optional)
 *             → 3번(toMap) · 4번(max/min+Optional) 은 A반·B반 코드와 겹치지 않는 메소드 사용
 */
public class Test2 {

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("아반떼",     "현대", 2000, 15),
                new Car("쏘나타",     "현대", 3000, 13),
                new Car("팰리세이드", "현대", 4800, 9),
                new Car("셀토스",     "기아", 2500, 14),
                new Car("쏘렌토",     "기아", 3800, 12),
                new Car("카니발",     "기아", 4200, 10),
                new Car("캡처",       "르노", 2800, 13),
                new Car("아르카나",   "르노", 3200, 11)
        );

        // 1번 : 연비 13km/L 이상 차가 몇 대인지 센다 (count)
        System.out.println("== 연비 13km/L 이상 차 수 ==");
        long count = cars.stream()
                .filter(c -> c.getEfficiency() >= 13)
                .count();
        System.out.println(count + "대");
        System.out.println();

        // 2번 : 가격이 비싼 순서로 상위 3개를 "차종(가격만원)" 형태로 출력 (sorted + limit)
        System.out.println("== 가격 상위 3개 차종 ==");
        cars.stream()
                .sorted(Comparator.comparingInt(Car::getPrice).reversed())
                .limit(3)
                .map(c -> c.getName() + "(" + c.getPrice() + "만원)")
                .forEach(System.out::println);
        System.out.println();

        // 3번 : 차종 -> 연비 Map 으로 변환하여 차종 가나다순으로 출력 (toMap)
        System.out.println("== 차종별 연비표 (차종 가나다순) ==");
        Map<String, Integer> effByName = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getEfficiency));
        effByName.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "km/L"));
        System.out.println();

        
        // 4번 : 종합 - 연비 12km/L 이상 차를 가격 내림차순 상위 3개 + 1위
        System.out.println("== 연비 12km/L 이상, 가격 상위 3개 ==");
        List<Car> top = cars.stream()
                .filter(c -> c.getEfficiency() >= 12)
                .sorted(Comparator.comparingInt(Car::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());
        top.stream()
                .map(c -> c.getName() + "(" + c.getPrice() + "만원)")
                .forEach(System.out::println);
        System.out.println("1위: " + top.get(0).getName());
    }
}
