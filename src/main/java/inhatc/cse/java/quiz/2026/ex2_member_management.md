# 2026년도 2번 - 회원 관리 프로그램

다음은 회원 데이터 예시이다.

```java
List<Member> members = Arrays.asList(
    new Member("user01", "김민재", 22, Role.USER),
    new Member("user02", "박서연", 19, Role.ADMIN),
    new Member("user03", "이도윤", 25, Role.MANAGER),
    new Member("user04", "최유진", 30, Role.USER),
    new Member("user01", "김민재", 22, Role.USER)
);
```

위 데이터를 이용하여 다음 기능을 구현하시오.

1. 20세 이상 회원만 출력하시오.
2. 역할이 ADMIN인 회원만 출력하시오.
3. 나이 기준 오름차순 정렬 결과를 출력하시오.
4. 역할별 회원 목록을 출력하시오.
5. 중복 회원 제거 후 출력하시오.
6. 이름이 가장 긴 회원을 출력하시오.

조건:

- `Role`은 `enum`으로 작성한다.
- 회원의 중복 여부는 아이디 기준으로 판단한다.
- 나이 정렬용 `Comparator`는 내부 클래스(internal/inner class)로 작성한다.

설명과 함께 출력 결과를 보여주는 실행 파일을 작성하시오.

-- 작성자: 자동 생성

