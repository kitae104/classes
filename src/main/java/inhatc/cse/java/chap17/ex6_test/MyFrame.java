package inhatc.cse.java.chap17.ex6_test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button2Button;
    private JPanel panel1;
    private JButton button1Button;

    public MyFrame() {
        setTitle("프레임 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        add(panel1);
        button1Button.addActionListener(this);
        button2Button.addActionListener(this);
    }

    public static void main(String[] args) {
        new  MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1Button) {
            JOptionPane.showMessageDialog(this, "버튼 1이 클릭되었습니다.");
        } else if(e.getSource() == button2Button) {
            JOptionPane.showMessageDialog(this, "버튼 2가 클릭되었습니다.");
        }
    }
}
