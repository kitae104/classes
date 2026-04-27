package inhatc.cse.java.quiz.c;

public class Ex1Answer {

    enum Region {
        SEOUL(3000),
        CAPITAL(3500),
        LOCAL(4000),
        JEJU(6000);

        private final int fee;

        Region(int fee) {
            this.fee = fee;
        }

        public int shippingFee(int orderAmount) {
            return orderAmount >= 50_000 ? 0 : fee;
        }
    }

    public static void main(String[] args) {
        int orderAmount = 42_000;
        Region region = Region.JEJU;

        int finalAmount = orderAmount + region.shippingFee(orderAmount);
        System.out.println("finalAmount=" + finalAmount);
    }
}
