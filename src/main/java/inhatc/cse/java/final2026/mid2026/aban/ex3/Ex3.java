package inhatc.cse.java.mid2026.aban.ex3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
다음 데이터를 이용하여 다음 기능을 구현하시오.
(1, "공지사항입니다", "관리자", 150, PostType.NOTICE)
(2, "자바 질문", "홍길동", 80, PostType.QNA)
(3, "자유게시판 글", "김철수", 120, PostType.FREE)
(4, "스프링 질문", "홍길동", 200, PostType.QNA)
(5, "점심 추천", "이영희", 50, PostType.FREE)

1. 조회수 100 이상인 게시글만 출력하시오.
2. 조회수 기준 내림차순 정렬 결과를 출력하시오.
3. 작성자별 게시글 수를 출력하시오.
4. 제목에 "질문"이 포함된 게시글만 출력하시오.
5. 가장 조회수가 높은 게시글을 출력하시오.
 */
public class Ex3 {
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(
                new Post(1, "공지사항입니다", "관리자", 150, PostType.NOTICE),
                new Post(2, "자바 질문", "홍길동", 80, PostType.QNA),
                new Post(3, "자유게시판 글", "김철수", 120, PostType.FREE),
                new Post(4, "스프링 질문", "홍길동", 200, PostType.QNA),
                new Post(5, "점심 추천", "이영희", 50, PostType.FREE)
        );

        System.out.println("==== 원본 리스트 ====");
        posts.forEach(System.out::println);

        // 1) 조회수 100 이상
        System.out.println("\n==== 1) 조회수 >= 100 ====");
        posts.stream()
                .filter(p -> p.getViews() >= 100)
                .forEach(System.out::println);

        // 2) 게시판 유형별 글 수
        System.out.println("\n==== 2) 유형별 글 수 ====");
        Map<PostType, Long> byType = posts.stream()
                .collect(Collectors.groupingBy(Post::getType, Collectors.counting()));
        for (PostType t : PostType.values()) {
            System.out.printf("%s : %d%n", t, byType.getOrDefault(t, 0L));
        }

        // 3) 조회수 기준 내림차순 정렬
        System.out.println("\n==== 3) 조회수 기준 내림차순 ====");
        posts.stream()
                .sorted(Comparator.comparingInt(Post::getViews).reversed())
                .forEach(System.out::println);

        // 4) 작성자별 게시글 수
        System.out.println("\n==== 4) 작성자별 게시글 수 ====");
        Map<String, Long> byAuthor = posts.stream()
                .collect(Collectors.groupingBy(Post::getAuthor, Collectors.counting()));
        byAuthor.forEach((a, cnt) -> System.out.printf("%s : %d%n", a, cnt));

        // 5) 제목에 "질문" 포함
        System.out.println("\n==== 5) 제목에 '질문' 포함 ====");
        posts.stream()
                .filter(p -> p.getTitle().contains("질문"))
                .forEach(System.out::println);

        // 6) 가장 조회수 높은 게시글
        System.out.println("\n==== 6) 최고 조회수 게시글 ====");
        posts.stream()
                .max(Comparator.comparingInt(Post::getViews))
                .ifPresent(System.out::println);
    }
}
