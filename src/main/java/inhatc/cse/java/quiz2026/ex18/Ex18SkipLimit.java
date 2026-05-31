package inhatc.cse.java.quiz2026.ex18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 난이도: 중
 * skip + limit - 페이징 처리
 */
public class Ex18SkipLimit {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
        
        System.out.println("원본: " + numbers);
        
        // skip()으로 처음 3개 건너뛴 후, limit()로 2개만 선택
        List<Integer> result = numbers.stream()
                                       .skip(3)  // 처음 3개 건너뛰기
                                       .limit(2)  // 그 다음 2개만 선택
                                       .collect(Collectors.toList());
        
        System.out.println("skip(3).limit(2) 결과: " + result);
    }
}

