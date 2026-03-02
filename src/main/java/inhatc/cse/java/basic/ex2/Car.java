package inhatc.cse.java.basic.ex2;

public class Car {
    private String name;	// 자동차 이름

    public Car()
    {
        super();
    }

    public Car(String name)
    {
        super();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}