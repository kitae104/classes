package inhatc.cse.java.chap16.ex1_basic;

public class ThreadTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread());

        MyThead thread1 = new MyThead();
        thread1.start();
        MyThead thread2 = new MyThead();
        thread2.start();

        System.out.println("end");
    }
}
