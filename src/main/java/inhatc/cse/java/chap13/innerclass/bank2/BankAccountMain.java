package inhatc.cse.java.chap13.innerclass.bank2;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("기태", 10000);

        BankAccount.Transaction t1 = account.new Transaction(3000);
        t1.deposit();

        BankAccount.Transaction t2 = account.new Transaction(2000);
        t2.withdraw();

        account.printBalance();
    }
}
