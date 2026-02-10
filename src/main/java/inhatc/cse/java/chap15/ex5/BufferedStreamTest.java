package inhatc.cse.java.chap15.ex5;

import java.io.*;

public class BufferedStreamTest {

    public static void main(String[] args) {
        long millisecond = 0;

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Windows\\explorer.exe"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Temp\\my_explorer.exe"))) {

            millisecond = System.currentTimeMillis();

            int i;
            while((i = bis.read()) != -1) {
                bos.write(i);
            }

            millisecond = System.currentTimeMillis() - millisecond;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("파일 복사하는 데 " + millisecond + " milliseconds 소요되었습니다.");
    }
}
