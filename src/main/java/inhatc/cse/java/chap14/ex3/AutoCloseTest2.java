package inhatc.cse.java.chap14.ex3;

public class AutoCloseTest2 {
    public static void main(String[] args) {
        AutoCloseObj obj = new AutoCloseObj();

        try(obj) {
            System.out.println("111");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("예외 부분입니다");
        }
    }
}
