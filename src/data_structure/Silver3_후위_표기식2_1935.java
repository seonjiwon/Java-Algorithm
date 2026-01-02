package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 유형: 자료구조 / Stack 2. 로직: Stack 에 값을 넣어 가면서 연산자가 나오면 앞에 나온 수들과 연산을 수행 3. 팁:
 */
public class Silver3_후위_표기식2_1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        double[] numbers = new double[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Double.parseDouble(br.readLine());
        }

        double solution = solution(n, input, numbers);
        System.out.println(String.format("%.2f", solution));

        br.close();
    }

    private static double solution(int n, String input, double[] numbers) {
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i));
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                double second = stack.pollLast();
                double first = stack.pollLast();

                double operateValue = 0;
                if (ch.equals("+")) {
                    operateValue = first + second;
                } else if (ch.equals("-")) {
                    operateValue = first - second;
                } else if (ch.equals("*")) {
                    operateValue = first * second;
                } else {
                    operateValue = first / second;
                }
                stack.offer(operateValue);
            } else {
                stack.offer(numbers[ch.charAt(0) - 'A']);
            }
        }

        return stack.poll();
    }
}
