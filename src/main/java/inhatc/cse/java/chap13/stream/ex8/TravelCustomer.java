package inhatc.cse.java.chap13.stream.ex8;

public class TravelCustomer {

    private String name;   // 고객 이름
	private int age;       // 나이
	private int price;     // 여행 경비
    
    public TravelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "TravelCustomer [name=" + name + ", age=" + age + ", price=" + price + "]";
    }

}
