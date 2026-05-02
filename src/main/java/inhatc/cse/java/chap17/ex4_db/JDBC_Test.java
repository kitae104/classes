package inhatc.cse.java.chap17.ex4_db;

import javax.swing.*;
import java.sql.*;

public class JDBC_Test {
    public static void main(String[] args) {

        try {
            // 1. 오라클 드라이버 설치
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 드라이버 메니저 연결
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javastudy",
                    "root", "1111");

            Statement stmt = conn.createStatement();

            // 데이서 삽입(Insert)
//			String insertSQL =
//					"INSERT INTO MEMBER (ID, PW, AGE, NAME) "
//				  + "VALUES('E1', '333', 33, '박태환')";
//
//			stmt.executeUpdate(insertSQL);

            String updateSql =
                    "UPDATE MEMBER " +
                            "SET 	PW='888', " +
                            "		AGE=30, " +
                            "		NAME='최재석' " +
                            "WHERE ID='B1'";
            System.out.println(updateSql);
            stmt.executeUpdate(updateSql);

            String delId = JOptionPane.showInputDialog("지우고 싶은 ID");
            String deleteSql = "DELETE FROM MEMBER WHERE ID='" + delId + "'";
            System.out.println(deleteSql);
            stmt.executeUpdate(deleteSql);


            // 데이터 검색
//			String findId = JOptionPane.showInputDialog("찾고싶은 ID");
//			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER WHERE id = '" + findId + "'");

            ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER");

            System.out.println("--------------------------------");
            while(rs.next()) {
                String id = rs.getString("id");
                String pw = rs.getString("pw");
                int age = rs.getInt("age");
                String name = rs.getString("name");

                System.out.println(id + "\t| " + pw + "\t| " + age + "\t| " + name);
            }
            System.out.println("--------------------------------");

            System.out.println("OK!");

            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("DB 연결 오류 또는 쿼리 오류 입니다.");
            e.printStackTrace();
        }

    }
}
