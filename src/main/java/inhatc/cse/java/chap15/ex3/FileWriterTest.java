package inhatc.cse.java.chap15.ex3;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {

        try(FileWriter fw = new FileWriter("test.txt")) {
            fw.write('A');
            char buf[] = {'B','C','D','E','F','G'};

            fw.write(buf);
            fw.write("안녕하세요. 잘 써지네요");
            fw.write(buf, 1, 2);
            fw.write("65");
        }
        System.out.println("출력이 완료되었습니다.");
    }
}
