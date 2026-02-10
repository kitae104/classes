package inhatc.cse.java.chap12.ex1_generics.ex1_basic;

// T : 타입 매개변수
public class GenericPrinter<T> {
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
}
