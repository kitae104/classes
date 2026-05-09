package inhatc.cse.java.chap17.ex3_guichat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatFrame extends JFrame implements ActionListener {

    // ── GUI 컴포넌트 ──────────────────────────────
    private JPanel    panelCenter, panelSouth;
    private JTextField tf;
    private JButton    btn;
    private JTextArea  ta;

    // ── 네트워크 관련 ────────────────────────────
    private Socket       socket = null;
    private BufferedReader in   = null;
    private BufferedWriter out  = null;

    public ChatFrame(String title, int width, int height, int x, int y) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);
        setSize(width, height);
        setLayout(new BorderLayout());
        setCenter();  setSouth();
        setVisible(true);
        tf.requestFocus();
    }

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

    private void setSouth() {
        panelSouth = new JPanel();
        tf = new JTextField(18);
        tf.addActionListener(this);
        panelSouth.add(tf);
        btn = new JButton("전송");
        btn.addActionListener(this);
        panelSouth.add(btn);
        add(panelSouth, BorderLayout.SOUTH);
    }

    // ── 이벤트: 전송 버튼 or Enter ───────────────
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn || e.getSource() == tf) {
            try {
                String outMsg = tf.getText();
                out.write(outMsg + "\n");
                out.flush();
                ta.append("[클라이언트] : " + outMsg + "\n");
                tf.setText("");
                tf.requestFocus();
            } catch (IOException e1) { e1.printStackTrace(); }
        }
    }

    // ── 서버 연결 후 수신 루프 ──────────────────
    private void runClient() {
        try {
            socket = new Socket("localhost", 9999);
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String inMsg;
            while(true) {
                inMsg = in.readLine();            // 서버 응답 수신 (블로킹)
                ta.append("[서버] : " + inMsg + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { out.close(); in.close(); socket.close(); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }

    public static void main(String[] args) {
        ChatFrame cf = new ChatFrame("Client", 300, 400, 700, 200);
        cf.runClient();     // 창 생성 후 서버 연결 및 수신 루프 시작
    }
}