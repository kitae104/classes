package inhatc.cse.java.chap13.stream.ex7;

import java.util.Arrays;

public class ReduceTest {
    public static void main(String[] args) {

        String[] greetings = { "안녕하세요~~~", "hello", "Good morning", "반갑습니다^^" };

        String shortest1 = Arrays.stream(greetings)
                .reduce((s1, s2) -> {
                    if (s1.getBytes().length <= s2.getBytes().length) { // 바이트 길이 비교, 짧은 쪽 선택
                        return s1;
                    } else {
                        return s2;
                    }
                })
                .get();
        System.out.println(shortest1);

        String longuest2 = Arrays.stream(greetings)
                .reduce(new CompareString())
                .get();
        System.out.println(longuest2);
    }
}
