package inhatc.cse.java.chap17.ex5_login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    private JPanel panBase, panCenter, panSouth;
    private JButton btnLogin;
    private JLabel lbl1, lbl2;
    private JTextField tfID;
    private JPasswordField tfPW;

    public Login(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocation(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃
        setLayout(new BorderLayout());

        createPanBase();


        setVisible(true);
    }

    private void createPanBase() {
        panBase = new JPanel();
        panBase.setLayout(new BorderLayout());
        panBase.setBackground(Color.RED);

        createPanCenter();
        panBase.add(panCenter, BorderLayout.CENTER);
        createPanSouth();
        panBase.add(panSouth, BorderLayout.SOUTH);

        add(panBase);
    }

    private void createPanCenter() {
        panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(2, 2));
        panCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        lbl1 = new JLabel("ID :", JLabel.CENTER);
        tfID = new JTextField("A1", 15);

        lbl2 = new JLabel("PW :", JLabel.CENTER);
        tfPW = new JPasswordField("777", 15);

        panCenter.add(lbl1);
        panCenter.add(tfID);
        panCenter.add(lbl2);
        panCenter.add(tfPW);
    }

    private void createPanSouth() {
        panSouth = new JPanel();
        //panSouth.setBackground(Color.YELLOW);

        btnLogin = new JButton("로그인");
        btnLogin.addActionListener(this);
        panSouth.add(btnLogin);
    }

    public static void main(String[] args) {
        //DB.init();
        new Login("Login", 300, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btnLogin) {
            String id = tfID.getText();
            String pw = tfPW.getText();

            boolean check = checkIDPW(id, pw);
            if (check) {
                System.out.println("로그인 성공");
                // 새로운 폼 올리기.
                this.dispose();

            } else {
                System.out.println("로그인 실패");
                JOptionPane.showMessageDialog(null, "로그인 실패했습니다.");
                tfID.setText("");
                tfPW.setText("");
                tfID.requestFocus();
            }
        }

    }

    private boolean checkIDPW(String id, String pw) {
        boolean check = false;
        String sql = "SELECT * FROM MEMBER WHERE ID = '" + id + "' AND PW='" + pw + "'";
        System.out.println(sql);
        ResultSet rs = DB.getResultSet(sql);
        try {
            if (rs.next()) {
                System.out.println(rs.getString(1));
                check = true;
            } else {
                System.out.println("해당 사용자가 없습니다.");
                check = false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return check;
    }
}