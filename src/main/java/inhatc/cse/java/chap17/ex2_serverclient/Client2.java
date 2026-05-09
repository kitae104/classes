package inhatc.cse.java.chap17.ex2_serverclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 9999);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner sc = new Scanner(System.in)
        ) {
            while (true) {
                System.out.print("보내기 >>");
                String outMsg = sc.nextLine();

                out.write(outMsg + "\n");
                out.flush();

                if (outMsg.equalsIgnoreCase("bye")) {
                    break;
                }

                String inMsg = in.readLine();
                System.out.println("서버 >> : " + inMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

