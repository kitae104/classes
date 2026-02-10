package inhatc.cse.java.chap13.innerclass.bank2;

public class BankAccount {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    class Transaction {
        private int amount;

        public Transaction(int amount) {
            this.amount = amount;
        }

        public void deposit() {
            balance += amount;
            System.out.println(owner + " 계좌에 " + amount + "원 입금");
        }

        public void withdraw() {
            balance -= amount;
            System.out.println(owner + " 계좌에서 " + amount + "원 출금");
        }
    }

    public void printBalance() {
        System.out.println(owner + " 계좌의 현재 잔액: " + balance + "원");
    }

}
