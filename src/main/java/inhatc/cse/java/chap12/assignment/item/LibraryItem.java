package inhatc.cse.java.chap12.assignment.item;

public abstract class LibraryItem {
    private String itemId;
    private String title;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }

    public String getItemId() { return itemId; }
    public String getTitle()  { return title; }

    // 추상 메서드: 각 자료의 정보를 출력한다
    public abstract void displayInfo();
}
