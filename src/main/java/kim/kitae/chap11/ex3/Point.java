package kim.kitae.chap11.ex3;

public class Point {

    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x = " + x + "," + "y = " + y;
    }
}
