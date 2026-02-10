package inhatc.cse.java.chap12.ex2_collection.ex2_linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // 데이터 추가
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println("현재 큐: " + queue);

        // 맨 앞 요소 확인
        System.out.println("peek(): " + queue.peek());

        // 데이터 제거
        System.out.println("poll(): " + queue.poll());
        System.out.println("poll(): " + queue.poll());

        System.out.println("남은 큐: " + queue);
    }
}
