package inhatc.cse.java.chap17.ex3_multichat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerFrame extends JFrame implements ActionListener {

    private JPanel panelCenter;
    private JPanel panelSouth;
    private JTextField tf;
    private JButton btn;
    private JButton btn2;
    private JTextArea ta;

    // 네트워크 관련
    private ServerSocket server = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;

    private ArrayList<ServerThread> threadList = new ArrayList<ServerThread>();

    public ServerFrame(String title, int width, int height, int x, int y) {

        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);
        setSize(width, height);
        setLayout(new BorderLayout());

        setCenter();
        setSouth();

        setVisible(true);

        tf.setFocusable(true);
        tf.requestFocus();
    }

    private void setCenter() {
        panelCenter = new JPanel();
        panelCenter.setBackground(Color.BLUE);
        panelCenter.setLayout(new BorderLayout());

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
        //panelSouth.setBackground(Color.RED);

        tf = new JTextField(18);
        tf.addActionListener(this);
        panelSouth.add(tf);

        btn = new JButton("전송");
        btn.addActionListener(this);

        panelSouth.add(btn);

        add(panelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == btn || obj == tf) {

            try
            {
                String outMsg = tf.getText();
                out.write(outMsg + "\n");
                out.flush();
                ta.append("[서버] : " + outMsg + "\n");
                tf.setText("");
                tf.requestFocus();
            }
            catch (IOException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public JButton getBtn() {
        return btn;
    }

    private void setSocket()
    {
        try
        {
            server = new ServerSocket(9999);
            ta.append("연결 대기중.....\n");
            while(true) {
                Socket socket = server.accept();
                ta.append("연결 되었습니다.\n");
                ServerThread st = new ServerThread(socket, threadList);
                threadList.add(st);
                st.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ServerFrame sf = new ServerFrame("Server", 300, 400, 400, 200);
        sf.setSocket();
    }

}