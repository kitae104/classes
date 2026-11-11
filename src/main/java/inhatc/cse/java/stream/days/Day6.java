package inhatc.cse.java.stream.days;

<<<<<<< Updated upstream
import java.util.List;

/**
 * reduce()를 이용한 주문 금액 계산
 * <p>
 * 요구사항
 * 1. stream()을 사용하여 주문 데이터를 처리하세요.
 * 2. map()을 이용하여 각 주문의 금액(price × quantity)을 계산하세요.
 * 3. reduce()를 이용하여 전체 주문 금액을 합산하세요.
 * 4. 주문 금액이 100,000원 이상인 상품만 filter()로 추출하세요.
 * 5. 해당 상품에는 주문 금액의 10%를 할인 적용하세요.
 * 6. 할인된 주문 금액을 다시 reduce()로 합산하세요.
 * 7. sum()과 일반 for, while 반복문은 사용하지 마세요.
 * 8. 모든 금액은 정수로 계산하며, 입력된 단가와 수량은 양수이고 계산 결과는 int 범위를 초과하지 않는다고 가정합니다.
 * 9. 할인은 주문별로 적용하며, 100,000원 미만인 주문에는 할인을 적용하지 않습니다.
 */
public class Day6 {

    record Order(String name, int price, int quantity) {
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Keyboard", 50000, 2),
                new Order("Mouse", 30000, 3),
                new Order("Monitor", 250000, 1),
                new Order("USB", 15000, 4),
                new Order("Speaker", 80000, 2)
        );

        // 주문별 금액 계산
        System.out.println("=== 주문별 금액 ===");
        orders.forEach(order -> System.out.println(order.name() + " : " + (order.price() * order.quantity()) + "원"));

        // map()를 이용하여 각 주문의 금액(price × quantity)을 계산하고, reduce()를 이용하여 전체 주문 금액을 합산
        Integer totalMoney = orders.stream()
                .map(order -> order.price() * order.quantity())
                .reduce(0, (total, amount) -> total + amount);
        System.out.println("\n전체 주문 금액: " + totalMoney);

        // 주문 금액이 100,000원 이상인 상품만 filter()로 추출하고, 해당 상품에는 주문 금액의 10%를 할인 적용 후 reduce()로 합산
        List<Order> discountList = orders.stream()
                .filter(order -> order.price() * order.quantity() >= 100000)
                .toList();

        System.out.println("\n=== 할인 대상 상품 ===");
        discountList.forEach(item -> System.out.println(item.name() + " : " + (item.price() * item.quantity()) + "원"));

        // 할인 대상 금액 합계 
        Integer totalDiscountedMoney = discountList.stream()
                .map(item -> item.price() * item.quantity())
                .reduce(0, Integer::sum);

        // 주문별 10% 할인 금액 합산 
        Integer totalDiscount = discountList.stream()
                .map(item -> (item.price() * item.quantity()) / 10)
                .reduce(0, Integer::sum);

        // 전체 주문의 할인 적용 후 금액 합산
        Integer finalMoney = orders.stream()
                .map(order -> {
                    int amount = order.price() * order.quantity();
                    return amount >= 100000 ? amount - (amount / 10) : amount;
                })
                .reduce(0, Integer::sum);


        System.out.println("할인 대상 금액: " + totalDiscountedMoney + "원");
        System.out.println("총 할인 금액: " + totalDiscount + "원");
        System.out.println("할인 적용 후 금액: " + finalMoney + "원");

=======
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 조건에 맞는 최고 점수 학생 찾기
 *
 * 요구사항
 *
 * 1. stream()을 사용하세요.
 * 2. filter()를 이용하여 전공이 Computer인 학생만 선택하세요.
 * 3. 점수가 80점 이상인 학생만 추출하세요.
 * 4. max()와 Comparator.comparingInt()를 이용하여 최고 점수 학생을 찾으세요.
 * 5. 검색 결과를 Optional<Student>로 저장하세요.
 * 6. ifPresentOrElse()를 이용하여 결과를 출력하세요.
 * 7. for, while 반복문은 사용하지 마세요.
 */
public class Day6 {

    record Student(String name, String major, int score) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", "Computer", 95),
                new Student("Lee", "Electronic", 88),
                new Student("Park", "Computer", 72),
                new Student("Choi", "Computer", 91),
                new Student("Jung", "Mechanical", 85),
                new Student("Han", "Computer", 67),
                new Student("Kang", "Electronic", 93)
        );

        // filter()를 이용하여 전공이 Computer인 학생만 선택하세요.
        List<Student> computerMajor = students.stream()
                .filter(s -> s.major.equals("Computer"))
                .toList();
        System.out.println("Computer 전공 학생: " + computerMajor);

        // 점수가 80점 이상인 학생만 추출하세요.
        List<Student> over80Student = students.stream()
                .filter(s -> s.score >= 80)
                .toList();
        System.out.println("점수가 80점 이상인 학생: " + over80Student);

        // max()와 Comparator.comparingInt()를 이용하여 최고 점수 학생을 찾으세요.
        Optional<Student> maxStudent = students.stream()
                .max(Comparator.comparingInt(Student::score));

        // 검색 결과를 출력하세요.
        maxStudent.ifPresentOrElse(
                s -> System.out.println("최고 점수 학생: " + s),
                () -> System.out.println("학생이 없습니다.")
        );

        if(maxStudent.isPresent()) {
            Student student = maxStudent.get();
            System.out.println("==== 검색 결과 ====");
            System.out.println("학생 이름: " + student.name());
            System.out.println("학생 전공: " + student.major());
            System.out.println("학생 점수: " + student.score());

        }
>>>>>>> Stashed changes
    }
}
