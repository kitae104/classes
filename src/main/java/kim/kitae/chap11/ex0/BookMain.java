package kim.kitae.chap11.ex0;

public class BookMain {

    public static void main(String[] args) {
        Book book1 = new Book(1, "Java Programming");
        System.out.println(book1);
        System.out.println(book1.toString());

        BookLombok book2 = new BookLombok(2, "Lombok in Action");
        book2.setBookNumber(22);
        book2.setBookTitle("자바 프로그래밍");
        System.out.println(book2);
    }
}
