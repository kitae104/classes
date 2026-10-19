package inhatc.cse.java.algorithm.days;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 가장 많이 등장한 문자 찾기
 *
 * 요구사항
 * 1. for 반복문을 사용하세요.
 * 2. HashMap<Character, Integer>를 사용하여 문자별 등장 횟수를 저장하세요.
 * 3. 공백은 계산하지 않습니다.
 * 4. 대문자와 소문자는 구분하지 않습니다.
 * 5. 가장 많이 등장한 문자와 등장 횟수를 출력하세요.
 * 6. 가장 많이 등장한 문자가 여러 개라면 알파벳순으로 가장 앞선 문자를 선택하세요.
 * 7. stream()과 Collections.frequency()는 사용하지 않습니다.
 */
public class Day3 {
    public static void main(String[] args) {
        String text = "Programming Java";

        Map<Character, Integer> frequency = new HashMap<>();

        // TODO 1. 문자열을 소문자로 변환
        String lowerCase = text.toLowerCase();

        // TODO 2. 문자열을 한 글자씩 순회
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            // TODO 3. 공백 제외
            if (c != ' ') { // 공백 제외
                // TODO 4. HashMap에 문자별 등장 횟수 저장
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
        }

        // TODO 5. 문자별 등장 횟수를 알파벳순으로 출력
        System.out.println("문자별 등장 횟수:");
        frequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // TODO 6. 가장 많이 등장한 문자 찾기
        frequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .skip(frequency.size() - 1) // 가장 많이 등장한 문자만 남기기
                .forEach(entry -> System.out.println("가장 많이 등장한 문자: " + entry.getKey() + ", 등장 횟수: " + entry.getValue()));


        Map<Character, Integer> treeFreq = new TreeMap<>();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            // TODO 3. 공백 제외
            if (c != ' ') { // 공백 제외
                // TODO 4. HashMap에 문자별 등장 횟수 저장
                treeFreq.put(c, treeFreq.getOrDefault(c, 0) + 1);
            }
        }

        System.out.println("문자별 등장 횟수 (TreeMap):");
        treeFreq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .skip(treeFreq.size() - 1) // 가장 많이 등장한 문자만 남기기
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
