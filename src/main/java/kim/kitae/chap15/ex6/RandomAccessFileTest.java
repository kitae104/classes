package kim.kitae.chap15.ex6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile("src/main/resources/random.txt", "rw");
        rf.writeInt(100);
        System.out.println("파일 포인터 위치:" + rf.getFilePointer( ));
        rf.writeDouble(3.14);
        System.out.println("파일 포인터 위치:" + rf.getFilePointer( ));
        rf.writeUTF("안");
        System.out.println("파일 포인터 위치:" + rf.getFilePointer( ));
        rf.writeUTF("안녕");
        System.out.println("파일 포인터 위치:" + rf.getFilePointer( ));

        rf.seek(0); // 파일 포인터를 처음 위치로 이동
        System.out.println("파일 포인터 위치:" + rf.getFilePointer( ));

        int i = rf.readInt();
        double d = rf.readDouble();
        String str = rf.readUTF();
        String str2 = rf.readUTF();


        System.out.println("파일 포인터 위치:" + rf.getFilePointer( ));
        System.out.println(i);
        System.out.println(d);
        System.out.println(str);
        System.out.println(str2);
    }
}
