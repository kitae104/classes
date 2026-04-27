package inhatc.cse.java.quiz.a;

import java.util.List;

public class Ex2Answer {

    public static void main(String[] args) {
        List<String> words = List.of("java", "stream", "quiz", "openbook");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(words.get(i));
        }

        System.out.println(sb);
    }
}
