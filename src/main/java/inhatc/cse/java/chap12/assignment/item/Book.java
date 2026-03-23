package inhatc.cse.java.chap12.assignment.item;

public class Book extends LibraryItem {
    // TODO: author 필드를 추가하세요

    public Book(String itemId, String title, String author) {
        super(itemId, title);
        // TODO: author 초기화
    }

    // TODO: author getter를 작성하세요

    @Override
    public void displayInfo() {
        // TODO: "[도서] ID: B001, 제목: 자바의 정석, 저자: 남궁성" 형식으로 출력하세요
    }
}
