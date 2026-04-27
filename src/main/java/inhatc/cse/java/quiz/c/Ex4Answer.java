package inhatc.cse.java.quiz.c;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ex4Answer {

    static class BrowserHistory {
        private final Deque<String> backStack = new ArrayDeque<>();
        private final Deque<String> forwardStack = new ArrayDeque<>();
        private String current;

        public void visit(String url) {
            if (current != null) {
                backStack.push(current);
            }
            current = url;
            forwardStack.clear();
        }

        public void back() {
            if (backStack.isEmpty()) {
                return;
            }
            forwardStack.push(current);
            current = backStack.pop();
        }

        public void forward() {
            if (forwardStack.isEmpty()) {
                return;
            }
            backStack.push(current);
            current = forwardStack.pop();
        }

        public String current() {
            return current;
        }
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();

        history.visit("A");
        history.visit("B");
        history.visit("C");
        history.back();
        history.back();
        history.forward();

        System.out.println("current=" + history.current());
    }
}
