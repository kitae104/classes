package inhatc.cse.java.chap12.assignment.storage;

import inhatc.cse.java.chap12.assignment.item.Book;
import inhatc.cse.java.chap12.assignment.item.Magazine;

public class StorageTest {
    public static void main(String[] args) {

        // 도서 보관소
        Storage<Book> bookStorage = new Storage<>();
        bookStorage.addItem(new Book("B001", "자바의 정석", "남궁성"));
        bookStorage.addItem(new Book("B002", "Clean Code", "Robert C. Martin"));

        System.out.println("=== 도서 보관소 ===");
        bookStorage.showAll();
        System.out.println("총 " + bookStorage.getCount() + "권\n");

        System.out.println("B001 제거 성공: " + bookStorage.removeItem("B001"));
        bookStorage.showAll();
        System.out.println("총 " + bookStorage.getCount() + "권\n");

        // 잡지 보관소
        Storage<Magazine> magazineStorage = new Storage<>();
        magazineStorage.addItem(new Magazine("M001", "과학동아", 202));
        magazineStorage.addItem(new Magazine("M002", "내셔널지오그래픽", 55));

        System.out.println("=== 잡지 보관소 ===");
        magazineStorage.showAll();
        System.out.println("총 " + magazineStorage.getCount() + "권");

        /* 예상 출력:
        === 도서 보관소 ===
        [도서] ID: B001, 제목: 자바의 정석, 저자: 남궁성
        [도서] ID: B002, 제목: Clean Code, 저자: Robert C. Martin
        총 2권

        B001 제거 성공: true
        [도서] ID: B002, 제목: Clean Code, 저자: Robert C. Martin
        총 1권

        === 잡지 보관소 ===
        [잡지] ID: M001, 제목: 과학동아, 호수: 202
        [잡지] ID: M002, 제목: 내셔널지오그래픽, 호수: 55
        총 2권
        */
    }
}
