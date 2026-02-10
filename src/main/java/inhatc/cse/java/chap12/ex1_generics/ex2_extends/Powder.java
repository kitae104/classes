package inhatc.cse.java.chap12.ex1_generics.ex2_extends;

public class Powder extends Material {
    public void doPrinting() {
        System.out.println("Powder 재료로 출력합니다.");
    }

    public String toString() {
        return "재료는 Powder입니다.";
    }
}
