package inhatc.cse.java.final2026.cban;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * C반 4번 (난이도: 중상)
 * filter + mapToInt + summaryStatistics + (filter + sorted + findFirst)
 *
 * 2015년 이후(2015년 포함) 개봉한 영화만 대상으로,
 * 관객수의 통계 정보(편수 / 합계 / 최대 / 최소 / 평균)를 출력하고,
 * 그 중 관객수가 가장 많은 영화의 제목을 출력한다.
 */
public class Ex4 {

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

        // filter(2015년 이후) -> mapToInt(관객수) -> summaryStatistics
        IntSummaryStatistics stats = movies.stream()
                .filter(m -> m.getYear() >= 2015)
                .mapToInt(Movie::getAudience)
                .summaryStatistics();

        System.out.println("== 2015년 이후 개봉 영화 관객수 통계 ==");
        System.out.println("편수 : " + stats.getCount() + "편");
        System.out.println("합계 : " + stats.getSum() + "만명");
        System.out.println("최대 : " + stats.getMax() + "만명");
        System.out.println("최소 : " + stats.getMin() + "만명");
        System.out.println("평균 : " + String.format("%.1f", stats.getAverage()) + "만명");

        // 2015년 이후 영화 중 관객수가 가장 많은 영화 제목
        String topMovie = movies.stream()
                .filter(m -> m.getYear() >= 2015)
                .sorted(Comparator.comparingInt(Movie::getAudience).reversed())
                .map(Movie::getTitle)
                .findFirst()
                .orElse("없음");

        System.out.println("최다 관객 영화 : " + topMovie);
    }
}
