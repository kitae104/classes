# 2026년도 4번 - 도서 관리 프로그램

다음은 도서 목록 예시이다.

```java
Set<Book> books = new HashSet<>();

books.add(new Book("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE));
books.add(new Book("B002", "스프링 입문", "김영한", BookStatus.RENTED));
books.add(new Book("B003", "이펙티브 자바", "조슈아 블로크", BookStatus.AVAILABLE));
books.add(new Book("B004", "혼자 공부하는 자바", "신용권", BookStatus.AVAILABLE));
books.add(new Book("B001", "자바의 정석", "남궁성", BookStatus.AVAILABLE));
```

위 데이터를 이용하여 다음 기능을 구현하시오.

1. 대출 가능한 도서만 출력하시오.
2. 저자명 기준 오름차순 정렬하여 출력하시오.
3. 제목에 "자바"가 포함된 도서만 출력하시오.
4. 도서 상태별 권수를 출력하시오.
5. 제목 길이가 가장 긴 도서를 출력하시오.

조건:

- `BookStatus`는 `enum`으로 작성한다.
- 도서의 중복 여부는 도서 코드(code) 기준으로 판단한다.
- 정렬은 스트림과 람다식을 사용한다.

설명과 함께 출력 결과를 보여주는 실행 파일을 작성하시오.

-- 작성자: 자동 생성

