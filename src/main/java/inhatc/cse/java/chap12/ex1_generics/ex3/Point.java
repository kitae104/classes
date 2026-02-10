package inhatc.cse.java.chap12.ex1_generics.ex3;

public class Point<T, V> {
    private T x;
    private V y;

    public Point(T x, V y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public V getY() {
        return y;
    }

    public void setY(V y) {
        this.y = y;
    }

    public String toString() {
        return "x : " + x + ", y : " + y;
    }
    
}
