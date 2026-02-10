package inhatc.cse.java.chap13.innerclass.bank1;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("기태", 10000);

        Transaction t1 = new Transaction(3000);
        t1.deposit(account.getBalance(), account.getOwner());

        Transaction t2 = new Transaction(2000);
        t2.withdraw(account.getBalance(), account.getOwner());

        account.printBalance();
    }
}
