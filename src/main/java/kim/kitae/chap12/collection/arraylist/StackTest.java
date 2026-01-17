package kim.kitae.chap12.collection.arraylist;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // 데이터 추가
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("현재 스택: " + stack);

        // 맨 위 요소 확인
        System.out.println("peek(): " + stack.peek());

        // 데이터 제거
        System.out.println("pop(): " + stack.pop());
        System.out.println("pop(): " + stack.pop());

        System.out.println("남은 스택: " + stack);
    }
}
