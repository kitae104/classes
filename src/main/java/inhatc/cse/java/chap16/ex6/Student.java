package inhatc.cse.java.chap16.ex6;

public class Student extends Thread{
    @Override
    public void run() {
        try {
            String title = LibraryMain.library.lendBook();
            Thread.sleep(5000);
            LibraryMain.library.returnBook(title);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
