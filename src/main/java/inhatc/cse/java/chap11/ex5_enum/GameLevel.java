package inhatc.cse.java.chap11.ex5_enum;

public enum GameLevel {
    BEGINNER_LEVEL(1, "초보자"),
    ADVANCED_LEVEL(2, "중급자"),
    SUPER_LEVEL(3, "고급자");

    private int level;
    private String hint;

    GameLevel(int level, String hint){
        this.level = level;
        this.hint = hint;
    }

    public int getLevel() {
        return level;
    }

    public String getHint() {
        return hint;
    }
}
