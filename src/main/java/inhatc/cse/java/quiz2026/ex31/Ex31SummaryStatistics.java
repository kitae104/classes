package inhatc.cse.java.quiz2026.ex31;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 난이도: 상
 * IntSummaryStatistics - 통계 정보 한 번에 구하기
 */
public class Ex31SummaryStatistics {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);
        
        System.out.println("숫자 리스트: " + numbers);
        
        // summaryStatistics()로 통계 정보를 한 번에 구함
        IntSummaryStatistics stats = numbers.stream()
                                             .mapToInt(Integer::intValue)
                                             .summaryStatistics();
        
        System.out.println("\n통계 정보:");
        System.out.println("개수: " + stats.getCount());
        System.out.println("합계: " + stats.getSum());
        System.out.println("최솟값: " + stats.getMin());
        System.out.println("최댓값: " + stats.getMax());
        System.out.println("평균: " + String.format("%.2f", stats.getAverage()));
    }
}

