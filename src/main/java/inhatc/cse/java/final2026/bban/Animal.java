package inhatc.cse.java.final2026.bban;

public class Animal {
    private String name;
    private String type;
    private int age;
    private int weight;

    public Animal(String name, String type, int age, int weight) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.weight = weight;
    }

    public String getName()   { return name; }
    public String getType()   { return type; }
    public int    getAge()    { return age; }
    public int    getWeight() { return weight; }
}

