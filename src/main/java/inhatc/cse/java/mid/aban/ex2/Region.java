package inhatc.cse.java.mid.aban.ex2;

public enum Region {
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
