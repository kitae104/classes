package inhatc.cse.java.chap12.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        // 데이터 추가
        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민수", 95);
        scores.put("영희", 88); // 같은 키 → 값 덮어쓰기

        // 전체 출력
        System.out.println("점수 목록: " + scores);

        // 특정 값 조회
        System.out.println("철수 점수: " + scores.get("철수"));

        // 존재 여부 확인
        System.out.println("민수 존재? " + scores.containsKey("민수"));

        // 반복 출력
        for (String name : scores.keySet()) {
            System.out.println(name + " : " + scores.get(name));
        }
    }
}
