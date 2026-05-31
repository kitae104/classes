package inhatc.cse.java.chap17.ex0_frame;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    public LoginForm() {
        setTitle("로그인 폼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // 화면 중앙에 배치

        add(panel1);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        setVisible(true);
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
    }
}
