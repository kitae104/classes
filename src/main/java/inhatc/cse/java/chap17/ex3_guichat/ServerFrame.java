package inhatc.cse.java.chap17.ex3_guichat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame extends JFrame implements ActionListener {

    // ── GUI 컴포넌트 ──────────────────────────────
    private JPanel    panelCenter, panelSouth;
    private JTextField tf;
    private JButton    btn;
    private JTextArea  ta;

    // ── 네트워크 관련 ────────────────────────────
    private ServerSocket server = null;
    private BufferedWriter out  = null;

    // ── 생성자: 레이아웃 초기화 ─────────────────
    public ServerFrame(String title, int width, int height, int x, int y) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);
        setSize(width, height);
        setLayout(new BorderLayout());
        setCenter();  setSouth();
        setVisible(true);
        tf.requestFocus();
    }

    // ── 중앙 패널: JTextArea (수신 메시지 표시) ──
    private void setCenter() {
        panelCenter = new JPanel(new BorderLayout());
        ta = new JTextArea(7, 20);
        ta.setEditable(false);
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelCenter.add(sp);
        add(panelCenter, BorderLayout.CENTER);
    }

    // ── 하단 패널: JTextField + 전송 버튼 ────────
    private void setSouth() {
        panelSouth = new JPanel();
        tf = new JTextField(18);
        tf.addActionListener(this);   // Enter 키 이벤트
        panelSouth.add(tf);
        btn = new JButton("전송");
        btn.addActionListener(this);  // 버튼 클릭 이벤트
        panelSouth.add(btn);
        add(panelSouth, BorderLayout.SOUTH);
    }

    // ── 이벤트 처리: 전송 버튼 or Enter ──────────
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn || e.getSource() == tf) {
            try {
                String outMsg = tf.getText();
                out.write(outMsg + "\n");
                out.flush();
                ta.append("[서버] : " + outMsg + "\n");
                tf.setText("");
                tf.requestFocus();
            } catch (IOException e1) { e1.printStackTrace(); }
        }
    }

    // ── 소켓 대기 및 연결 처리 ───────────────────
    private void setSocket() {
        try {
            server = new ServerSocket(9999);
            ta.append("연결 대기중.....\n");

            Socket socket = server.accept();   // 클라이언트 연결 대기
            ta.append("연결 되었습니다.\n");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            String inMsg;
            while(true) {
                inMsg = in.readLine();          // 클라이언트 메시지 수신
                if(inMsg.equalsIgnoreCase("bye")) break;
                ta.append("[클라이언트] : " + inMsg + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        ServerFrame sf = new ServerFrame("Server", 300, 400, 400, 200);
        sf.setSocket();    // 창 생성 후 소켓 대기 시작
    }
}