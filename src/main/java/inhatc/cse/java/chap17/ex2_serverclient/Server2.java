package inhatc.cse.java.chap17.ex2_serverclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void main(String[] args) {
        try (
            ServerSocket server = new ServerSocket(9999);
            Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("연결 대기중.....");

            try (
                Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                System.out.println("연결 되었습니다.");

                while (true) {
                    String inMsg = in.readLine();
                    if (inMsg == null || inMsg.equalsIgnoreCase("bye")) {
                        System.out.println("클라이언트가 나갔습니다.");
                        break;
                    }

                    // 정상 메시지인 경우
                    System.out.println("클라이언트 : " + inMsg);

                    System.out.print("보내기 >>");
                    String outMsg = sc.nextLine();
                    out.write(outMsg + "\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

