package inhatc.cse.java.chap14.ex3;

public class AutoCloseTest {
    public static void main(String[] args) {
		AutoCloseObj obj = new AutoCloseObj();
		try (AutoCloseObj obj2 = obj){
            System.out.println("111");
			throw new Exception();            
		}catch(Exception e) {
			System.out.println("예외 부분입니다");
		}
	}
}
