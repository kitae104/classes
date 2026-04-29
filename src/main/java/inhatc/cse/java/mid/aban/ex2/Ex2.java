package inhatc.cse.java.mid.aban.ex2;
/*
배송 지역 enum Region을 만들고 기본 배송비를 설정하세요.

배송비
SEOUL: 3000
CAPITAL: 3500
LOCAL: 4000
JEJU: 6000

요구사항
주문금액이 50000원 이상이면 배송비 0원
주문금액 42000원, 지역 JEJU일 때 최종 결제 금액 출력
 */
public class Ex2 {
    public static void main(String[] args) {
        int orderAmount = 42000;
        Region region = Region.JEJU;

        int shippingCost = region.shippingFee(orderAmount);
        int finalAmount = orderAmount + shippingCost;

        System.out.println("최종 결제 금액: " + finalAmount + "원");
    }
}
