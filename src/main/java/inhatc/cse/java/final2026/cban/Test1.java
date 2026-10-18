package inhatc.cse.java.final2026.cban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ================================================================
 *  C반 - 1세트 (산) 정답 소스
 * ================================================================
 *  데이터: 산(Mountain) - name(산이름), region(지역), height(높이m), visitors(방문객, 만 명)
 *  C반 성격: 합계(sum) / 목록 연결(joining) / 중복 제거(distinct) / 누적(reduce)
 *           → 3번(distinct) · 4번(reduce) 는 A반·B반 코드와 겹치지 않는 메소드 사용
 */
public class Test1 {

    public static void main(String[] args) {
        List<Mountain> mountains = Arrays.asList(
                new Mountain("설악산", "강원", 1708, 350),
                new Mountain("태백산", "강원", 1567, 120),
                new Mountain("지리산", "경상", 1915, 280),
                new Mountain("가야산", "경상", 1430, 90),
                new Mountain("한라산", "전라", 1947, 400),
                new Mountain("무등산", "전라", 1187, 250),
                new Mountain("오대산", "강원", 1563, 100)
        );

        // 1번 : 전체 산의 방문객 합계 (mapToInt + sum)
        System.out.println("== 전체 산 방문객 합계 ==");
        int total = mountains.stream()
                .mapToInt(Mountain::getVisitors)
                .sum();
        System.out.println(total + "만 명");
        System.out.println();

        // 2번 : 높이 1,600m 이상 산 이름을 한 줄로 연결 (filter + map + joining)
        System.out.println("== 1,600m 이상 산 목록 ==");
        String names = mountains.stream()
                .filter(m -> m.getHeight() >= 1600)
                .map(Mountain::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names);
        System.out.println();

        // 3번 : 산들이 위치한 지역을 중복 없이 가나다순으로 출력 (map + distinct + sorted)
        System.out.println("== 산이 위치한 지역 종류 (가나다순) ==");
        mountains.stream()
                .map(Mountain::getRegion)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // 4번 : reduce 로 전체 높이 합계와 최고 높이를 구한다 (reduce)
        System.out.println("== 높이 reduce 집계 ==");
        int heightSum = mountains.stream()
                .mapToInt(Mountain::getHeight)
                .reduce(0, (a, b) -> a + b);
        int heightMax = mountains.stream()
                .mapToInt(Mountain::getHeight)
                .reduce(0, Math::max);
        System.out.println("높이 합계(reduce): " + heightSum + "m");
        System.out.println("최고 높이(reduce): " + heightMax + "m");
        System.out.println();
        
    }
}
