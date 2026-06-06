package inhatc.cse.java.final2026.cban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * C반 5번 (난이도: 상)
 * filter + groupingBy + summingInt + entrySet 스트림 + sorted + map + joining + max
 *
 * 평점(score)이 85점 이상인 영화만 대상으로,
 * 장르별 총 관객수(audience 합)를 구한 뒤,
 * 총 관객수 내림차순으로 정렬하여 "장르(총관객수만명)" 형식을 " > "로 이어 한 줄로 출력하고,
 * 마지막에 총 관객수가 가장 많은 장르의 이름을 출력한다.
 */
public class Ex5 {

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

        // 1. filter(평점 85점 이상) -> 2. groupingBy(장르) + summingInt(관객수)
        Map<String, Integer> audienceByGenre = movies.stream()
                .filter(m -> m.getScore() >= 85)
                .collect(Collectors.groupingBy(Movie::getGenre,
                                               Collectors.summingInt(Movie::getAudience)));

        // 3. entrySet 스트림 -> sorted(총관객수 내림차순) -> map(형식) -> joining
        String line = audienceByGenre.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed())
                .map(e -> e.getKey() + "(" + e.getValue() + "만명)")
                .collect(Collectors.joining(" > "));

        System.out.println("== 평점 85점 이상, 장르별 총 관객수 (내림차순) ==");
        System.out.println(line);

        // 총 관객수가 가장 많은 장르
        String topGenre = audienceByGenre.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("없음");

        System.out.println("최다 관객 장르: " + topGenre);
    }
}
