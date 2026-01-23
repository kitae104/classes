package kim.kitae.chap16.ex3;

public class JoinTest extends Thread {

    int start;
    int end;
    int sum;

    public JoinTest(int start, int end) {
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

        JoinTest joinA = new JoinTest(1, 50);
        JoinTest joinB = new JoinTest(51, 100);

        joinA.start();
//        Thread.sleep(1000);
        joinB.start();

        int total = joinA.sum + joinB.sum;
        System.out.println(joinA.sum + "+" + joinB.sum + "=" + total );
    }
}
