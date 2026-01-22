package kim.kitae.chap16.ex1;

public class MyThead extends Thread{

    public void run(){
        int i;
        for(i=0; i<=200; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i );
        }
    }
}
