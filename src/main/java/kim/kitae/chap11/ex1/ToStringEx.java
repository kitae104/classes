package kim.kitae.chap11.ex1;

public class ToStringEx {
    public static void main(String[] args) {
        Book book1 = new Book(200, "개미");

        System.out.println(book1);
        System.out.println(book1.toString());
    }
}
