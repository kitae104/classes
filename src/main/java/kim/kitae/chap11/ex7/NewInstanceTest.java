package kim.kitae.chap11.ex7;

public class NewInstanceTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Person person1 = new Person();
        System.out.println(person1);

        Class pClass = Class.forName("kim.kitae.chap11.ex7.Person");
        Person person2 = (Person)pClass.newInstance();
        System.out.println(person2);

        Person person3 = (Person)pClass.newInstance();
        System.out.println(person3);
    }
}
