package inhatc.cse.java.algorithm.days;

import java.util.ArrayDeque;

/**
 * 스택을 이용한 괄호 검사
 *
 *  요구사항
 * 1. ArrayDeque<Character>를 스택으로 사용하세요.
 * 2. for 반복문을 사용하여 문자열을 순회하세요.
 * 3. 여는 괄호 (, {, [를 만나면 스택에 저장하세요.
 * 4. 닫는 괄호를 만나면 스택의 가장 위에 있는 괄호와 비교하세요.
 * 5. 괄호의 종류가 일치하지 않으면 false를 반환하세요.
 * 6. 문자열 처리가 끝난 후 스택이 비어 있어야 올바른 괄호입니다.
 * 7. 시간 복잡도 O(n)으로 구현하세요.
 * 8. stream()과 정규표현식은 사용하지 마세요.
 */
public class Day6 {
    public static void main(String[] args) {
        String[] expressions = {
                "{[()]}",
                "({[]})",
                "([)]",
                "((()))",
                "{[(])}",
                "(()",
                "())",
                ""
        };

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (String expression : expressions) {
            boolean isValid = true;
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == '}' && top != '{') ||
                            (c == ']' && top != '[')) {
                        isValid = false;
                        break;
                    }
                }
            }
            isValid = isValid && stack.isEmpty();
            System.out.println(expression + " ---> " + isValid);
            stack.clear(); // 다음 표현식을 위해 스택 초기화
        }
    }
}
