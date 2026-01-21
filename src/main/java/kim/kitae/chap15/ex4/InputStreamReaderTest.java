package kim.kitae.chap15.ex4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

    public static void main(String[] args) {

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/resources/input.txt"))) {
            int i;
            while((i = isr.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
