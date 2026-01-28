package kim.kitae.chap11.ex3;

import java.util.Objects;

public class Circle implements Cloneable{

    private Point point;
    private int radius;

    Circle(int x, int y, int radius){
        this.radius = radius;
        point = new Point(x, y);
    }

    public String toString(){
        return "원점은 " + point + "이고," + "반지름은 " + radius + "입니다.";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(point, circle.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, radius);
    }
}
