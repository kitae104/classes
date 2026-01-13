package kim.kitae.chap13.innerclass.bank1;

public class BankAccount {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void printBalance() {
        System.out.println("현재 잔액: " + balance + "원");
    }
}
