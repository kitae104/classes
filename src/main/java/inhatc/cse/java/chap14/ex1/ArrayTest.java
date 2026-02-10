package inhatc.cse.java.chap14.ex1;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0; i <= 5; i++) {
            arr[i] = i;
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
        System.out.println("프로그램 종료");
    }
}
