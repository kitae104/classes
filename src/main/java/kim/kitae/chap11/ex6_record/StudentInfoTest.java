package kim.kitae.chap11.ex6_record;

public class StudentInfoTest {
    public static void main(String[] args) {

        StudentInfo studentInfo = new StudentInfo(12345, "최치원");
        StudentInfo studentInfo2 = new StudentInfo(12345, "김유신");

        System.out.println(studentInfo.equals(studentInfo2));
        System.out.println(studentInfo.name());
        System.out.println(studentInfo);
    }
}
