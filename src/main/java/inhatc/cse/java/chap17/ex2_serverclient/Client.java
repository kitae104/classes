package inhatc.cse.java.chap17.ex2_serverclient;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket("localhost", 9999);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true) {
                System.out.print("보내기 >>");
                String outMsg = sc.nextLine();

                if(outMsg.equalsIgnoreCase("bye")) {
                    out.write(outMsg + "\n");
                    out.flush();
                    break;
                }

                // 정상 메시지인 경우
                out.write(outMsg + "\n");
                out.flush();

                String inMsg = in.readLine();
                System.out.println("서버 >> : " + inMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
