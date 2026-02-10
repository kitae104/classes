package inhatc.cse.java.chap15.ex3;

import java.io.FileReader;
import java.io.IOException;


public class FileReaderTest {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("test.txt")){
            int i;
            while( (i = fr.read()) != -1){
                System.out.print((char)i);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
