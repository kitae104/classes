package kim.kitae.chap16.ex6;

public class LibraryMain{

    public static Library library = new Library();

    public static void main(String[] args) {
        Student std1 = new Student();
        Student std2 = new Student();
        Student std3 = new Student();
        Student std4 = new Student();
        Student std5 = new Student();
        Student std6 = new Student();
        Student std7 = new Student();
        Student std8 = new Student();

        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();
        std6.start();
        std7.start();
        std8.start();
    }
}
