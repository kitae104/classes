package kim.kitae.chap12.hashmap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        Map<String, Integer> scores = new TreeMap<>();

        // 데이터 추가
        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민수", 95);
        scores.put("지성", 93);
        scores.put("영희", 88); // 값 덮어쓰기

        // 자동 정렬 출력
        System.out.println("점수 목록: " + scores);

        // 범위 조회
        System.out.println("민수 이상: " + ((TreeMap<String, Integer>) scores).tailMap("민수"));

        // 반복 출력
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
