package inhatc.cse.java.quiz.b;

public class Ex2Answer {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.StringBuilder");
        StringBuilder sb = (StringBuilder) clazz.getDeclaredConstructor().newInstance();

        sb.append("OPEN").append('-').append("BOOK");
        System.out.println(sb);
    }
}
