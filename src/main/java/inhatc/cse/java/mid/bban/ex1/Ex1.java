package inhatc.cse.java.mid.bban.ex1;

/*
Level enum(BRONZE, SILVER, GOLD)을 만들고, 각 레벨별 적립률을 설정하세요.
적립률
● BRONZE: 1%
● SILVER: 3%
● GOLD: 5%

요구사항
결제 금액 120000원, 등급 GOLD일 때 적립 포인트를 계산해 출력하세요.
 */
public class Ex1 {
    public static void main(String[] args) {
        int amount = 120_000;
        Level level = Level.GOLD;

        int point = (int)(amount * level.getRate());
        System.out.println("포인트 : " + point);
    }
}
