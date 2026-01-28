package kim.kitae.chap11.ex5;

public class GameLevelTest {
    public static void main(String[] args) {
        GameLevel[] gameLevels = GameLevel.values();    // 열거 타입의 모든 상수를 배열로 반환
        for (GameLevel level : gameLevels) {
            System.out.println(level);
        }

        GameLevel gameLevel = GameLevel.valueOf("BEGINNER_LEVEL");
        System.out.println(gameLevel.getLevel());
        System.out.println(gameLevel.getHint());
    }
}
