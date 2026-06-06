package inhatc.cse.java.final2026.cban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * C반 2번 (난이도: 중하)
 * filter + sorted(내림차순) + map + forEach
 *
 * '액션' 장르 영화만 골라 관객수가 많은 순(내림차순)으로 정렬한 뒤,
 * "제목(관객수만명)" 형식으로 출력한다.
 */
public class Ex2 {

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

        System.out.println("== 액션 장르 영화 (관객수 내림차순) ==");
        movies.stream()
              .filter(m -> m.getGenre().equals("액션"))
              .sorted(Comparator.comparingInt(Movie::getAudience).reversed())
              .map(m -> m.getTitle() + "(" + m.getAudience() + "만명)")
              .forEach(System.out::println);
    }
}
