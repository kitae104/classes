package inhatc.cse.java.stream.ex2_advance;

import java.util.Arrays;
import java.util.List;

/**
 * Stream flatMap/distinct
 *
 * 문장 리스트를 단어 단위로 분해한 뒤, 소문자로 통일하고 중복 제거 후 오름차순 정렬하세요.
 *
 * ## 데이터
 * - "Java stream is powerful"
 * - "Stream API is useful"
 * - "java lambda"
 */
public class Ex1 {
    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java stream is powerful",
                "Stream API is useful",
                "java lambda"
        );

        // flatMap()은 스트림의 각 요소를 스트림으로 변환한 후, 모든 스트림을 하나의 스트림으로 평면화
        //1:N 매핑
        List<String> uniqueWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" "))) // 문장 -> 단어 스트림
                .map(String::toLowerCase) // 소문자로 변환
                .distinct() // 중복 제거
                .sorted() // 오름차순 정렬
                .toList();

        System.out.println(uniqueWords);
    }
}
