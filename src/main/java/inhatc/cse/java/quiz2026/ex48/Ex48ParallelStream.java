package inhatc.cse.java.quiz2026.ex48;

import java.util.stream.IntStream;

/**
 * 난이도: 상
 * parallelStream - 병렬 처리
 */
public class Ex48ParallelStream {
    
    // 소수 판별 함수
    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("1부터 100,000까지 소수 개수 구하기");
        System.out.println("(전체 범위를 줄였습니다. 실제로는 1,000,000)");
        
        // 일반 stream
        long start = System.currentTimeMillis();
        long count1 = IntStream.rangeClosed(1, 100000)
                               .filter(Ex48ParallelStream::isPrime)
                               .count();
        long elapsed1 = System.currentTimeMillis() - start;
        
        // parallelStream
        start = System.currentTimeMillis();
        long count2 = IntStream.rangeClosed(1, 100000)
                               .parallel()  // 병렬 처리
                               .filter(Ex48ParallelStream::isPrime)
                               .count();
        long elapsed2 = System.currentTimeMillis() - start;
        
        System.out.println("\n결과:");
        System.out.println("일반 stream - 소수 개수: " + count1 + ", 시간: " + elapsed1 + "ms");
        System.out.println("parallel stream - 소수 개수: " + count2 + ", 시간: " + elapsed2 + "ms");
    }
}

