package kim.kitae.chap13.innerclass;

class OutClass {
    private int outNum = 100;
    private static int sOutNum = 200;
    private InClass inClass;

    public OutClass() {
        inClass = new InClass();
    }

    public void usingClass() {
        inClass.inTest();
    }

    class InClass {
        int inNum = 10;

        void inTest() {
            System.out.println("OutClass outNum = " + outNum + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sOutNum = " + sOutNum + "(외부 클래스의 정적 변수)");
            System.out.println("inNum = " + inNum + "(내부 클래스의 인스턴스 변수)");
        }
    }   
}

public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();
        System.out.println();
        OutClass.InClass inClass = outClass.new InClass();
        inClass.inTest();
    }
}
