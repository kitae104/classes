package inhatc.cse.java.chap17.ex6_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static Connection conn;
    public static Statement stmt;

    public static void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javastudy",
                    "root", "root1234");
            stmt = conn.createStatement();
            System.out.println("DB 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("DB 연결 오류 또는 쿼리 오류 입니다.");
            e.printStackTrace();
        }
    }

    // 조회
    public static ResultSet getResultSet(String sql) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // 삽입, 수정, 삭제
    public static void executeQuery(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}