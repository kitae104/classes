package inhatc.cse.java.chap13.lambda.ex1;

public class TestMyNumber {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber() {
            @Override
            public int getMax(int num1, int num2) {
                return (num1 >= num2) ? num1 : num2;
            }
        };

        int max = myNumber.getMax(10, 20);
        System.out.println("더 큰 수: " + max);

        // 람다식으로 MyNumber 구현
        MyNumber maxNumber = (num1, num2) -> (num1 >= num2) ? num1 : num2;

        int result = maxNumber.getMax(10, 20);
        System.out.println("더 큰 수: " + result);
    }
}
