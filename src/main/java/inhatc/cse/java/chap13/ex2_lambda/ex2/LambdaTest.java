package inhatc.cse.java.chap13.ex2_lambda.ex2;

public class LambdaTest {
    public static void main(String[] args) {
        // 람다식을 인터페이스형 변수에 대입하고 그 변수를 사용해 람다식 구현부 호출
        PrintString printString = str -> System.out.println(str);
        printString.showString("Hello, Lambda_1");

        // 메소드의 매개변수로 람다식을 대입한 변수 전달
        showMyString(printString);

        PrintString returnStr = returnString();
        returnStr.showString("Hello");
    }

    // 매개변수를 인터페이스형으로 받음
    public static void showMyString(PrintString p) {
        p.showString("Hello, Lambda_2");
	}

    // 람다식을 반환하는 메소드
    public static PrintString returnString() {
        return str -> System.out.println(str + " world");
    }

}
