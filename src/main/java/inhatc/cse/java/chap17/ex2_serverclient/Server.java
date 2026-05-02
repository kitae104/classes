package inhatc.cse.java.chap17.ex2_serverclient;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);

        try {
            server = new ServerSocket(9999);
            System.out.println("연결 대기중.....");

            socket = server.accept();
            System.out.println("연결 되었습니다.");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true) {
                String inMsg = in.readLine();
                if(inMsg.equalsIgnoreCase("bye")) {
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
