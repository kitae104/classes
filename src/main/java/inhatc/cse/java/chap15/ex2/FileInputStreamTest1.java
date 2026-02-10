package inhatc.cse.java.chap15.ex2;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest1 {
    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("src/main/resources/input.txt")) {
            int data;

            while((data = fis.read()) != -1) {
                System.out.print((char)data);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("end");
    }
}
