package inhatc.cse.java.chap11.ex2;

public class StringEquals {
    public static void main(String[] args) {
        String str1 = new String("java");
        String str2 = new String("java");

        System.out.println(str1 == str2);          // false
        System.out.println(str1.equals(str2));     // true

        String str3 = "java";
        String str4 = "java";

        System.out.println(str3 == str4);          // true
        System.out.println(str3.equals(str4));     // true
    }
}
