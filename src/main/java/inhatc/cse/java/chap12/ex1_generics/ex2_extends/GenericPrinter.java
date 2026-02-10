package inhatc.cse.java.chap12.ex1_generics.ex2_extends;

public class GenericPrinter<T extends Material> {
    private T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    public String toString() {
        return material.toString();
    }

    public void printing() {
        material.doPrinting(); // T가 Material의 자손이므로 호출 가능
    }
}
