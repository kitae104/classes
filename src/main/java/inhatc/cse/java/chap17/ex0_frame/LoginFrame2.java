package inhatc.cse.java.chap17.ex0_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame2 extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    public LoginFrame2() {
        setTitle("로그인 폼");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new Color(200,200,200));

        add(panel1);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = textField2.getText();

                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(LoginFrame2.this, "로그인 성공!");
                } else {
                    JOptionPane.showMessageDialog(LoginFrame2.this, "로그인 실패! 아이디 또는 비밀번호가 틀렸습니다.");
                }
            }
        });
    }

    public static void main(String[] args) {
        LoginFrame2 loginForm = new LoginFrame2();
    }
}
