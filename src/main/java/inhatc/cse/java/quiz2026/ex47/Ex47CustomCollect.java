package inhatc.cse.java.quiz2026.ex47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 난이도: 상
 * 커스텀 collect - 여러 컬렉션으로 분산
 */
public class Ex47CustomCollect {
    
    // 짝수/홀수 결과를 담을 컨테이너
    static class EvenOddContainer {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        
        public void addEven(int num) {
            evens.add(num);
        }
        
        public void addOdd(int num) {
            odds.add(num);
        }
        
        @Override
        public String toString() {
            return "짝수: " + evens + "\n홀수: " + odds;
        }
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // collect()를 사용하여 짝수/홀수 분리
        EvenOddContainer result = numbers.stream()
                                          .collect(EvenOddContainer::new,
                                                   (container, n) -> {
                                                       if (n % 2 == 0) {
                                                           container.addEven(n);
                                                       } else {
                                                           container.addOdd(n);
                                                       }
                                                   },
                                                   (c1, c2) -> {
                                                       c1.evens.addAll(c2.evens);
                                                       c1.odds.addAll(c2.odds);
                                                   });
        
        System.out.println("\n분리 결과:");
        System.out.println(result);
    }
}

