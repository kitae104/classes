package kim.kitae.chap11;

import kim.kitae.Main;

public class StringEquals {
    public static void main(String[] args) {
        String str1 = new String("kitae");
        String str2 = new String("kitae");

        System.out.println(str1 == str2);          // false
        System.out.println(str1.equals(str2));     // true        
    }
}
