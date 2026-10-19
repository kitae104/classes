package inhatc.cse.java.final2026.bban;

public class Menu {
    private String name;
    private String category;
    private int price;
    private int calorie;

    public Menu(String name, String category, int price, int calorie) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.calorie = calorie;
    }

    public String getName()     { return name; }
    public String getCategory() { return category; }
    public int    getPrice()    { return price; }
    public int    getCalorie()  { return calorie; }
}
