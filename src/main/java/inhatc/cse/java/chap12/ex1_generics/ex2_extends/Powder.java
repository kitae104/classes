package inhatc.cse.java.chap12.ex1_generics.ex2_extends;

/**
 * Powder 클래스는 Material 클래스를 상속받아 doPrinting() 메서드를 구현하고, toString() 메서드를 오버라이드하여 재료 정보를 반환합니다.
 */
public class Powder extends Material {
    public void doPrinting() {
        System.out.println("Powder 재료로 출력합니다.");
    }

    public String toString() {
        return "재료는 Powder입니다.";
    }
}
