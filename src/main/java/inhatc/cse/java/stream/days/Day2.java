package inhatc.cse.java.stream.days;

import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Kim", "Lee", "Park", "Choi",
                "Kang", "Han", "Jung", "Kwon"
        );

        // 1. 4글자 이상인 이름의 개수를 세어 출력
        long count = names.stream()
                .filter(name -> name.length() >=4)
                .count();
        System.out.println("4글자 이상인 이름의 개수: " + count);

        // 2. 4글자 이상인 이름을 대문자로 변환하여 새로운 리스트로 출력
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .toList();
        System.out.println("4글자 이상인 이름 (대문자): " + filteredNames);

        // 3. 4글자 이상인 이름을 대문자로 변환하여 정렬된 새로운 리스트로 출력
        List<String> sortedNames = names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println("4글자 이상인 이름 (정렬): " + sortedNames);

        // 4. 4글자 이상인 이름을 대문자로 변환하여 내림차순으로 정렬된 새로운 리스트로 출력
        List<String> sortedNamesDesc = names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a)) // 내림차순 정렬
                .toList();
        System.out.println("4글자 이상인 이름 (내림차순 정렬): " + sortedNamesDesc);

        // 5. 4글자 이상인 이름을 대문자로 변환하여 오름차순으로 정렬된 새로운 리스트 중 K로 시작하는 이름만 필터링하여 출력
        List<String> filteredNamesDesc = names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .sorted((a, b) -> a.compareTo(b)) // 오름차순 정렬
                .filter(name -> name.startsWith("K")) // K로 시작하는 이름만 필터링
                .toList();
        System.out.println("4글자 이상인 이름 (K로 시작): " + filteredNamesDesc);
    }
}
