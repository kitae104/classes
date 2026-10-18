package inhatc.cse.java.final2026.cban;

public class Car {
    private String name;
    private String maker;
    private int price;
    private int efficiency;

    public Car(String name, String maker, int price, int efficiency) {
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.efficiency = efficiency;
    }

    public String getName()       { return name; }
    public String getMaker()      { return maker; }
    public int    getPrice()      { return price; }
    public int    getEfficiency() { return efficiency; }
}
