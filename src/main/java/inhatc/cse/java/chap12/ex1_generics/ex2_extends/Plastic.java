package inhatc.cse.java.chap12.ex1_generics.ex2_extends;

public class Plastic extends Material {
    public void doPrinting() {
		System.out.println("Plastic 재료로 출력합니다.");
	}
	
	public String toString() {
		return "재료는 Plastic입니다.";
	}
}
