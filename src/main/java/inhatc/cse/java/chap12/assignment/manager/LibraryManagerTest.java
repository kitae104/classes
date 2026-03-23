package inhatc.cse.java.chap12.assignment.manager;

import inhatc.cse.java.chap12.assignment.item.Book;
import inhatc.cse.java.chap12.assignment.storage.Storage;

import java.util.List;
import java.util.Map;

public class LibraryManagerTest {
    public static void main(String[] args) {

        // transferItems 테스트
        Storage<Book> storage1 = new Storage<>();
        storage1.addItem(new Book("B001", "자바의 정석", "남궁성"));
        storage1.addItem(new Book("B002", "자료구조와 알고리즘", "홍길동"));
        storage1.addItem(new Book("B003", "이펙티브 자바", "Joshua Bloch"));

        Storage<Book> storage2 = new Storage<>();
        storage2.addItem(new Book("B004", "Clean Code", "Robert C. Martin"));

        System.out.println("=== transferItems 테스트 ===");
        System.out.println("이동 전 창고1: " + storage1.getCount() + "권, 창고2: " + storage2.getCount() + "권");
        LibraryManager.transferItems(storage1, storage2);
        System.out.println("이동 후 창고1: " + storage1.getCount() + "권, 창고2: " + storage2.getCount() + "권\n");

        // findMostRecent 테스트
        System.out.println("=== findMostRecent 테스트 ===");
        Book recent = LibraryManager.findMostRecent(storage2);
        System.out.print("가장 최근 자료: ");
        if (recent != null) recent.displayInfo();
        System.out.println();

        // countItems 테스트
        System.out.println("=== countItems 테스트 ===");
        int count = LibraryManager.countItems(storage2, "자바");
        System.out.println("\"자바\" 포함 자료 수: " + count + "\n");

        // groupByFirstChar 테스트
        System.out.println("=== 카테고리별 분류 ===");
        Map<String, List<Book>> grouped = LibraryManager.groupByFirstChar(storage2);
        if (grouped != null) {
            for (Map.Entry<String, List<Book>> entry : grouped.entrySet()) {
                System.out.print("[" + entry.getKey() + "] → ");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(entry.getValue().get(i).getTitle());
                }
                System.out.println();
            }
        }

        /* 예상 출력:
        === transferItems 테스트 ===
        이동 전 창고1: 3권, 창고2: 1권
        이동 후 창고1: 0권, 창고2: 4권

        === findMostRecent 테스트 ===
        가장 최근 자료: [도서] ID: B003, 제목: 이펙티브 자바, 저자: Joshua Bloch

        === countItems 테스트 ===
        "자바" 포함 자료 수: 2

        === 카테고리별 분류 ===
        [자] → 자바의 정석, 자료구조와 알고리즘
        [이] → 이펙티브 자바
        [C] → Clean Code
        */
    }
}
