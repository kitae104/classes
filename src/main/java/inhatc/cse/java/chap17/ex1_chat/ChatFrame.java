package inhatc.cse.java.chap17.ex1_chat;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatFrame() {
        setTitle("간단한 채팅창");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 채팅 내용 출력 영역
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        // JTextArea에 스크롤 기능 추가
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // 입력창과 버튼을 담을 패널
        JPanel inputPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        sendButton = new JButton("전송");

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        // 버튼 클릭 이벤트
        sendButton.addActionListener(e -> sendMessage());

        // Enter 키 입력 이벤트
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String message = inputField.getText();

        if (!message.trim().isEmpty()) {
            chatArea.append("나: " + message + "\n");
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatFrame().setVisible(true);
        });
    }
}