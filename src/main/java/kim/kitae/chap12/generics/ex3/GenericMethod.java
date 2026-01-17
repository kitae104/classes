package kim.kitae.chap12.generics.ex3;

public class GenericMethod {
    public static void main(String[] args) {
        Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
        Point<Integer, Double> p2 = new Point<>(10, 10.0);

        double rect = GenericMethod.<Integer, Double>makeRectangle(p1, p2);
        System.out.println("두 점으로 만들어진 사각형의 넓이 : " + rect);

        double rect2 = GenericMethod.<Integer, Double>makeRectangle2(p1, p2);
        System.out.println("두 점으로 만들어진 사각형의 넓이 : " + rect2);
    }

    private static double makeRectangle(Point<Integer, Double> p1, Point<Integer, Double> p2) {
        double left = p1.getX();
        double right = p2.getX();
        double top = p1.getY();
        double bottom = p2.getY();

        double width = right - left;
        double height = bottom - top;

        return width * height;
    };

    private static <T, V> double makeRectangle2(Point<T, V> p1, Point<T, V> p2) {
        double left = ((Number) p1.getX()).doubleValue();
        double right = ((Number) p2.getX()).doubleValue();
        double top = ((Number) p1.getY()).doubleValue();
        double bottom = ((Number) p2.getY()).doubleValue();

        double width = right - left;
        double height = bottom - top;

        return width * height;
    }
}
