package inhatc.cse.java.final2026.aban;

public class Fruit {
    private String name;
    private String category;
    private int price;
    private int stock;

    public Fruit(String name, String category, int price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName()     { return name; }
    public String getCategory() { return category; }
    public int    getPrice()    { return price; }
    public int    getStock()    { return stock; }
}