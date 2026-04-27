package inhatc.cse.java.mid.bban.ex1;

public enum Level {
    BRONZE(0.01),
    SILVER(0.03),
    GOLD(0.05);

    public final double rate;

    private Level(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }
}
