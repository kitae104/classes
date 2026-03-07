package inhatc.cse.java.chap11.ex2_equals;

public class EqualsTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100, "이상원");
        Student studentLee2 = studentLee;
        Student studentSang = new Student(100, "이상원");

        if(studentLee == studentLee2)
            System.out.println("studentLee와 studentLee2의 주소는 같습니다.");
        else
            System.out.println("studentLee와 studentLee2의 주소는 다릅니다.");
        if(studentLee.equals(studentLee2))
            System.out.println("studentLee와 studentLee2는 동일합니다.");
        else
            System.out.println("studentLee와 studentLee2는 동일하지 않습니다.");


        if(studentLee == studentSang)
            System.out.println("studentLee와 studentSang의 주소는 같습니다.");
        else
            System.out.println("studentLee와 studentSang의 주소는 다릅니다");

        if(studentLee.equals(studentSang))
            System.out.println("studentLee와 studentSang은 동일합니다.");
        else
            System.out.println("studentLee와 studentSang은 동일하지 않습니다.");

        System.out.println("studentLee의 hashCode :" +studentLee.hashCode());
        System.out.println("studentSang의 hashCode :" +studentSang.hashCode());

        System.out.println("studentLee의 실제 주소값 :"+ System.identityHashCode(studentLee));
        System.out.println("studentSang의 실제 주소값 :"+ System.identityHashCode(studentSang));
    }
}
