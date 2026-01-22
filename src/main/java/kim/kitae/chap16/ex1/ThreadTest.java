package kim.kitae.chap16.ex1;

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
