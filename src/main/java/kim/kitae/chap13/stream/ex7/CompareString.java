package kim.kitae.chap13.stream.ex7;

import java.util.function.BinaryOperator;

public class CompareString implements BinaryOperator<String>{

    @Override
    public String apply(String s1, String s2) {
        if(s1.getBytes().length >= s2.getBytes().length) {  // 바이트 길이 비교
            return s1;
        } else {
            return s2;
        }
    }
}
