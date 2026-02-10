package inhatc.cse.java.chap16.ex3;

public class JoinTest2 extends Thread {

    int start;
    int end;
    int sum;

    public JoinTest2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        JoinTest2 joinA = new JoinTest2(1, 50);
        JoinTest2 joinB = new JoinTest2(51, 100);

        joinA.start();
        joinB.start();

        joinA.join();
        joinB.join();

        int total = joinA.sum + joinB.sum;
        System.out.println(joinA.sum + "+" + joinB.sum + "=" + total );
    }
}
