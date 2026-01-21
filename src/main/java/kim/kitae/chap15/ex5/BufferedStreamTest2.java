package kim.kitae.chap15.ex5;

import java.io.*;

public class BufferedStreamTest2 {

    public static void main(String[] args) {
        long millisecond = 0;

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Windows\\explorer.exe"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Temp\\my_explorer.exe"))) {

            millisecond = System.currentTimeMillis();

            // 버퍼를 활용한 바이트 배열 복사
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            millisecond = System.currentTimeMillis() - millisecond;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("파일 복사하는 데 " + millisecond + " milliseconds 소요되었습니다.");
    }
}
