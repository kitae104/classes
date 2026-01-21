package kim.kitae.chap15.ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputStreamTest2 {
    public static void main(String[] args) throws IOException {
        String text = Files.readString(Path.of("src/main/resources/input.txt"), StandardCharsets.UTF_8);
        System.out.println(text);
        System.out.println("=======================================");

        // 시스템의 현재 위치 확인
        String path = System.getProperty("user.dir");
        System.out.println(path);
        String text2 =  Files.readString(Path.of(path, "src/main/resources/input.txt"), StandardCharsets.UTF_8);
        System.out.println(text2);
    }
}
