package kim.kitae.chap15.ex4;

import java.io.*;

public class BufferedReaderTest {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
