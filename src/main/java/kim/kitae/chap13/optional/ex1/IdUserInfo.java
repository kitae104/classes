package kim.kitae.chap13.optional.ex1;

import kim.kitae.chap13.stream.ex3.UserInfo;

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
