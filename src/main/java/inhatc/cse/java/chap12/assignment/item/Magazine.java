package inhatc.cse.java.chap12.assignment.item;

public class Magazine extends LibraryItem {
    // TODO: issueNumber(int) 필드를 추가하세요

    public Magazine(String itemId, String title, int issueNumber) {
        super(itemId, title);
        // TODO: issueNumber 초기화
    }

    // TODO: issueNumber getter를 작성하세요

    @Override
    public void displayInfo() {
        // TODO: "[잡지] ID: M001, 제목: 과학동아, 호수: 202" 형식으로 출력하세요
    }
}
