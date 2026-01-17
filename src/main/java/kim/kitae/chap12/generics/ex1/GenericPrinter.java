package kim.kitae.chap12.generics.ex1;

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
