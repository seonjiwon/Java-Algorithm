
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22942
 */
public class Main {

    static int N;
    static boolean flag = false;

    static class Checker implements Comparable<Checker> {

        int no;
        int dot;

        public Checker(int no, int dot) {
            this.no = no;
            this.dot = dot;
        }

        @Override
        public int compareTo(Checker o) {
            return this.dot - o.dot;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Checker> points = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            points.add(new Checker(x, x - r));
            points.add(new Checker(x, x + r));
        }

        Collections.sort(points);

        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).dot == points.get(i + 1).dot) {
                System.out.println("NO");
                return;
            }
        }

        for (Checker point : points) {
            if (stack.isEmpty()) {
                stack.push(point.no);
            } else {
                if (stack.peek() == point.no) {
                    stack.pop();
                } else {
                    stack.push(point.no);
                }
            }
        }

        System.out.println(stack.isEmpty() ? "YES" : "NO");

        br.close();
    }

}
