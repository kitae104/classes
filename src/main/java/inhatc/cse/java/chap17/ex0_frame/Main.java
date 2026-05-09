package inhatc.cse.java.chap17.ex0_frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    private JTextField textField1;
    private JButton 전송Button;

    public Main() {
        setTitle("프레임 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        add(panel1);

//        전송Button.addActionListener(e -> {
//            String text = textField1.getText();
//            textArea1.append(text + "\n");
//            textField1.setText("");
//        });

        전송Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                textArea1.append(text + "\n");
                textField1.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
