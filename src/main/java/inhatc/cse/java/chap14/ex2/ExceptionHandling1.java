package inhatc.cse.java.chap14.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling1 {
    public static void main(String[] args) {
		FileInputStream fis = null;

        try {
            fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
			System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();


        }

		System.out.println("여기도 수행됩니다.");

    }
}
