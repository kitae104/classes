package kim.kitae.chap13.lambda.ex1;

@FunctionalInterface // 함수형 인터페이스 선언(의미 확인!)
public interface MyNumber {
    int getMax(int num1, int num2);
}
