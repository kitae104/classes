package inhatc.cse.java.final2026.cban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * C반 3번 (난이도: 중)
 * groupingBy + counting + entrySet 스트림 + sorted(다중 정렬) + forEach
 *
 * 장르별 영화 "편수"를 구한 뒤,
 * 편수 내림차순(편수가 같으면 장르명 가나다순)으로 정렬하여 출력한다.
 */
public class Ex3 {

    static class Movie {
        String title;
        String genre;
        int year;
        int score;
        int audience;

        public Movie(String title, String genre, int year, int score, int audience) {
            this.title = title;
            this.genre = genre;
            this.year = year;
            this.score = score;
            this.audience = audience;
        }

        public String getTitle() { return title; }
        public String getGenre() { return genre; }
        public int getYear() { return year; }
        public int getScore() { return score; }
        public int getAudience() { return audience; }
    }

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("기생충", "드라마", 2019, 95, 1008),
            new Movie("괴물", "액션", 2006, 88, 1301),
            new Movie("올드보이", "스릴러", 2003, 92, 326),
            new Movie("부산행", "액션", 2016, 85, 1156),
            new Movie("암살", "액션", 2015, 83, 1270),
            new Movie("택시운전사", "드라마", 2017, 89, 1218),
            new Movie("곡성", "스릴러", 2016, 87, 687),
            new Movie("82년생김지영", "드라마", 2019, 80, 367)
        );

        // groupingBy(장르) + counting() 으로 장르별 편수 계산
        Map<String, Long> countByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));

        System.out.println("== 장르별 영화 편수 (편수 내림차순, 동률은 장르명 가나다순) ==");
        countByGenre.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed()
                                  .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue() + "편"));
    }
}
