package kim.kitae.chap13.optional.ex2;

import java.util.ArrayList;
import java.util.Optional;

import kim.kitae.chap13.optional.ex1.IdUserInfo;

public class UserInfoTestUsingOptional {
    public static void main(String[] args) {
        ArrayList<IdUserInfo> userInfoList = new ArrayList<>();

        userInfoList.add(new IdUserInfo("김철수", 28, 1001));
        userInfoList.add(new IdUserInfo("이영희", 34, 1002));
        userInfoList.add(new IdUserInfo("박민수", 22, 1003));

        usingOptional(userInfoList);
    }

    private static void usingOptional(ArrayList<IdUserInfo> list) {

        Optional<IdUserInfo> userInfoOptional = getIdUserInfoByIdOptional(12348, list);

        // ifPresent() 메소드를 사용하여 값이 존재하는 경우에만 처리
        userInfoOptional.ifPresent(userInfo -> System.out.println("사용자 이름 찾음 : " + userInfo.getName()));

        // isPresent()를 사용하여 조건문 처리
        if (userInfoOptional.isPresent()) {
            System.out.println("사용자 이름 찾음 : " + userInfoOptional.get().getName());
        } else {
            System.out.println("사용자를 찾을 수 없습니다.");
        }

        // orElse()를 사용하여 기본값 설정
        IdUserInfo nameOrDefault = userInfoOptional.orElse(new IdUserInfo("기본사용자", 0, -1));
        System.out.println("사용자 이름 : " + nameOrDefault.getName());

        // orElseGet()를 사용하여 기본값을 느긋하게 계산
        IdUserInfo nameOrComputed = userInfoOptional.orElseGet(() -> generateDefaultIdUserInfo());
        System.out.println("사용자 이름 : " + nameOrComputed.getName());

        // orElseThrow()를 사용하여 값이 없을 때 예외 발생 및 처리
        try {
            IdUserInfo userInfo = userInfoOptional.orElseThrow(() -> new IllegalStateException("사용자를 찾을 수 없습니다."));
            System.out.println("사용자 이름 : " + userInfo.getName());
        } catch (IllegalStateException e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }
    }

    private static Optional<IdUserInfo> getIdUserInfoByIdOptional(int id, ArrayList<IdUserInfo> list) {
        for (IdUserInfo userInfo : list) {
            if (userInfo.getId() == id) {
                return Optional.of(userInfo); // Optional 객체로 감싸서 반환
            }
        }
        return Optional.empty();
    }

    private static IdUserInfo generateDefaultIdUserInfo() {
        return new IdUserInfo("기본사용자", 0, -1);
    }
}
