package kim.kitae.chap11.ex3;

public class ObjectCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Circle circle = new Circle(10, 20, 30);
        Circle copyCircle = (Circle) circle.clone();

        System.out.println(circle);
        System.out.println(copyCircle);

        System.out.println(circle.hashCode());
        System.out.println(copyCircle.hashCode());

        System.out.println(System.identityHashCode(circle));
        System.out.println(System.identityHashCode(copyCircle));
    }
}
