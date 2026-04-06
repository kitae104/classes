package inhatc.cse.java.chap13.ex4_optional.ex1_basic;

import inhatc.cse.java.chap13.ex3_stream.ex2_method.UserInfo;

public class IdUserInfo extends UserInfo {

    private int id; // 아이디

    public IdUserInfo(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
