package inhatc.cse.java.quiz.c;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Ex8Answer {

    record Post(String title, List<String> tags) {
    }

    public static void main(String[] args) {
        List<Post> posts = List.of(
                new Post("Post1", List.of("Java", "Stream", "API")),
                new Post("Post2", List.of("stream", "Lambda")),
                new Post("Post3", List.of("Java", "Optional"))
        );

        List<String> uniqueTags = posts.stream()
                .flatMap(post -> post.tags().stream())
                .map(String::toLowerCase)
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(LinkedHashSet::new),
                        List::copyOf
                ));

        System.out.println(uniqueTags);
    }
}
