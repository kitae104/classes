package inhatc.cse.java.stream.ex3_optional;

import java.util.List;
import java.util.Optional;

/**
 * Optional
 *
 * 사용자 목록에서 id로 이름을 조회하는 메서드를 작성하세요.
 *
 * ## 요구사항
 * 1. 반환 타입은 `Optional<String>`
 * 2. 찾지 못하면 `orElse("UNKNOWN")`으로 처리
 *
 * ## 데이터
 * - (1, "Kim")
 * - (2, "Lee")
 * - (3, "Park")
 */
public class Ex1 {
    record User(int id, String name) {}

    public static void main(String[] args) {
        List<User> userList = List.of(
                new User(1, "Kim"),
                new User(2, "Lee"),
                new User(3, "park")
        );

        String name = findNameById(userList, 4).orElseThrow(() -> new RuntimeException("UNKNOWN"));
        System.out.println(name);

    }

    private static Optional<String> findNameById(List<User> userList, int id) {
        return userList.stream()
                .filter(user -> user.id() == id)
                .map(User::name)
                .findFirst();
    }
}
