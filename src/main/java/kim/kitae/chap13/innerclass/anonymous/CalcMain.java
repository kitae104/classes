package kim.kitae.chap13.innerclass.anonymous;

public class CalcMain {
    public static void main(String[] args) {
        ICalc calc = new ICalc() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };

        int result = calc.add(10, 20);
        System.out.println("10 + 20 = " + result);
    }
}
