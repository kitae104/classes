package inhatc.cse.java.chap13.lambda.ex2;

public class TestLambda {
    public static void main(String[] args) {
        PrintString printString = str -> System.out.println(str);
        printString.showString("Hello, Lambda_1");
        showMyString(printString);

        PrintString returnStr = returnString();
        returnStr.showString("Hello");
    }

    public static void showMyString(PrintString p) {
        p.showString("Hello, Lambda_2");
	}

    public static PrintString returnString() {
        return str -> System.out.println(str + " world");
    }
}
