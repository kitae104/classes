package inhatc.cse.java.chap16.ex6;

import java.util.ArrayList;

public class Library {

    private ArrayList<String> shelf = new ArrayList<>();

    public Library() {
        shelf.add("태백산맥 1");
        shelf.add("태백산맥 2");
        shelf.add("태백산맥 3");
    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();
        while(shelf.size()==0) {
            System.out.println(t.getName() + " 기다림 시작");
            wait();
            System.out.println(t.getName() + " 기다림 종료");
        }
        String book = shelf.remove(0);
        System.out.println(t.getName() + " : " + book + " 대출");
        return book;
    }

    public synchronized void returnBook(String book) {
        Thread t = Thread.currentThread();
        shelf.add(book);
        notifyAll();
        System.out.println(t.getName() + " : " + book + " 반납");
    }
}
