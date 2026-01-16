package kim.kitae.chap13.stream.ex8;

import java.util.List;

public class TravelTest {

    public static void main(String[] args) {
        TravelCustomer customer1 = new TravelCustomer("이순신", 40, 100);
        TravelCustomer customer2 = new TravelCustomer("김유신", 20, 100);
        TravelCustomer customer3 = new TravelCustomer("홍길동", 13, 50);
        TravelCustomer customer4 = new TravelCustomer("홍길순", 23, 50);

        List<TravelCustomer> customerList = List.of(customer1, customer2, customer3, customer4);

        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customerList.stream()
                .map(c -> c.getName())
                .forEach(name -> System.out.println(name));

        int totalPrice = customerList.stream()
                .mapToInt(c -> c.getPrice()).sum();
        System.out.println("총 여행 비용은 :" + totalPrice + "입니다");

        System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
        customerList.stream()
                .filter(c -> c.getAge() >= 20)
                .map(c -> c.getName())
                .sorted()
                .forEach(name -> System.out.println(name));

    }
}
