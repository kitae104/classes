package inhatc.cse.java.quiz2026.ex43;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 난이도: 상
 * distinct by 특정 필드 - Set을 활용한 필터링
 */
public class Ex43StreamDistinctBy {
    
    static class Book {
        String id;
        String title;
        
        public Book(String id, String title) {
            this.id = id;
            this.title = title;
        }
        
        public String getId() {
            return id;
        }
        
        public String getTitle() {
            return title;
        }
        
        @Override
        public String toString() {
            return id + " - " + title;
        }
    }
    
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("B001", "Java Basics"),
            new Book("B002", "Java Basics"),
            new Book("B003", "Python Guide"),
            new Book("B004", "Java Basics"),
            new Book("B005", "SQL Query")
        );
        
        System.out.println("원본 도서 리스트:");
        books.forEach(System.out::println);
        
        // Set을 활용하여 제목별 중복 필터링
        Set<String> seenTitles = new HashSet<>();
        List<Book> uniqueByTitle = books.stream()
                                         .filter(book -> seenTitles.add(book.getTitle()))  // 처음 보는 제목만 true
                                         .collect(Collectors.toList());
        
        System.out.println("\n제목별 중복 제거 후:");
        uniqueByTitle.forEach(System.out::println);
    }
}

