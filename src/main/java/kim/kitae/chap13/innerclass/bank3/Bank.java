package kim.kitae.chap13.innerclass.bank3;

public class Bank {
    static class Policy {
        static final int MAX_WITHDRAW = 5000;

        static void printPolicy() {
            System.out.println("1회 최대 출금액: " + MAX_WITHDRAW + "원");
        }
    }
}
