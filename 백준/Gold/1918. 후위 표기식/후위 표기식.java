import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String solution = solution(input);
        System.out.println(solution);

        br.close();
    }

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);

            // 알파벳이면 바로 출력에 넣음
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch);
            }

            // '(' 이면 바로 출력에 넣음
            if (ch == '(') {
                stack.push(ch);
            }

            // ')' 이 나오면 이전 '(' 까지 출력에 넣음
            if (ch == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                if (stack.peek() == '(') {
                    stack.pop();
                }
            }

            // 연산자일 경우
            if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                while (!stack.isEmpty()
                    && stack.peek() != '('
                    && priority(stack.peek()) >= priority(ch)) {
                    sb.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static int priority(char op) {
        if (op == '*' || op == '/') {
            return 2;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        return 0;
    }
}
