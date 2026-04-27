package inhatc.cse.java.quiz.a;

public class Ex3Answer {

    enum Level {
        BRONZE(0.01),
        SILVER(0.03),
        GOLD(0.05);

        private final double rate;

        Level(double rate) {
            this.rate = rate;
        }

        public double getRate() {
            return rate;
        }
    }

    public static void main(String[] args) {
        int amount = 120_000;
        Level level = Level.GOLD;

        int point = (int) (amount * level.getRate());
        System.out.println("point=" + point);
    }
}
