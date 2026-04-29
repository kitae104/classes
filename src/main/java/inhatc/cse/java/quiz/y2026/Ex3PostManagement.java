package inhatc.cse.java.quiz.y2026;

import java.util.*;
import java.util.stream.Collectors;

public class Ex3PostManagement {

    enum PostType { NOTICE, QNA, FREE }

    static class Post {
        private final int id;
        private final String title;
        private final String author;
        private final int views;
        private final PostType type;

        Post(int id, String title, String author, int views, PostType type) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.views = views;
            this.type = type;
        }

        public int getId() { return id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public int getViews() { return views; }
        public PostType getType() { return type; }

        @Override
        public String toString() {
            return String.format("Post{id=%d, title='%s', author='%s', views=%d, type=%s}", id, title, author, views, type);
        }
    }

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

