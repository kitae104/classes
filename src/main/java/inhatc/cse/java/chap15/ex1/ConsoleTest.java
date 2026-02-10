package inhatc.cse.java.chap15.ex1;

import java.io.Console;

public class ConsoleTest {

    public static void main(String[] args) {

        Console console = System.console(); // 콘솔 객체 얻기(Null)

        System.out.println("이름:");
        String name = console.readLine();
        System.out.println("직업:");
        String job = console.readLine();
        System.out.println("비밀번호:");
        char[] pass = console.readPassword();
        String strPass = new String(pass);

        System.out.println(name);
        System.out.println(job);
        System.out.println(strPass);
    }
}
