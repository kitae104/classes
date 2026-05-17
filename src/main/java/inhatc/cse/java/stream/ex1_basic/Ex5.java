package inhatc.cse.java.stream.ex1_basic;

import java.util.List;

/**
 * 거래 목록에서 지출(음수 금액)만 골라 절댓값 합계를 구하세요.
 *
 * 데이터
 * ("A-1", 50000)
 * ("A-1", -12000)
 * ("B-1", -7000)
 * ("C-1", 10000)
 * ("A-1", -3000)
 */
public class Ex5 {
    record Data(String account, int amount) {}

    public static void main(String[] args) {
        List<Data> dataList = List.of(
                new Data("A-1", 50000),
                new Data("A-1", -12000),
                new Data("B-1", -7000),
                new Data("C-1", 10000),
                new Data("A-1", -3000)
        );

        int absSum = dataList.stream()
                .filter(data -> data.amount() < 0) // 지출(음수 금액)만 필터링
//                .mapToInt(data -> Math.abs(data.amount())) // 절댓값으로 변환
                .mapToInt(data -> data.amount()) // 금액
                .sum();// 합계 계산

        System.out.println("절대값 합계 : " + absSum);
    }
}
