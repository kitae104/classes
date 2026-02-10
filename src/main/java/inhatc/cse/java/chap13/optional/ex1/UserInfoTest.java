package inhatc.cse.java.chap13.optional.ex1;

import java.util.ArrayList;

public class UserInfoTest {

    public static void main(String[] args) {
        ArrayList<IdUserInfo> userInfoList = new ArrayList<>();
        
        userInfoList.add(new IdUserInfo("김철수", 28, 1001));
        userInfoList.add(new IdUserInfo("이영희", 34, 1002));
        userInfoList.add(new IdUserInfo("박민수", 22, 1003));

        // ID가 1002인 사용자 찾기
        IdUserInfo foundUser = getUserInfoById(userInfoList, 1004);
        if(foundUser != null) {
            System.out.println(foundUser.getName());
        } else {
            System.out.println("해당 사용자를 찾을 수 없습니다.");
        }
    }

    private static IdUserInfo getUserInfoById(ArrayList<IdUserInfo> userInfoList, int id) {
        for (IdUserInfo userInfo : userInfoList) {
            if (userInfo.getId() == id) {
                return userInfo;
            }
        }
        return null;
    }
}
