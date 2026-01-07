
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

    static Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        solution(input);

        for (String s : result) {
            System.out.println(s);
        }
        br.close();
    }

    private static void solution(String input) {
        List<int[]> parenthesisList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int previous = stack.pop();
                parenthesisList.add(new int[]{previous, i});
            }
        }

        List<int[]> current = new ArrayList<>();

        // 0개 ~ parenthesisList.size() 까지 제거하는 숫자
        boolean[] visited = new boolean[parenthesisList.size()];
        for (int i = 1; i <= parenthesisList.size(); i++) {
            dfs(input, parenthesisList, i, visited, current, 0);
        }
    }

    private static void dfs(String input, List<int[]> parenthesisList, int extractCount,
                            boolean[] visited, List<int[]> current, int start) {
        if (current.size() == extractCount) {
            StringBuilder sb = new StringBuilder();
            boolean flag;

            for (int i = 0; i < input.length(); i++) {
                flag = true;
                for (int[] ints : current) {
                    int left = ints[0];
                    int right = ints[1];
                    if (i == left || i == right) {
                        flag = false;
                    }
                }

                if (flag) {
                    sb.append(input.charAt(i));
                }
            }

            result.add(sb.toString());
            return;
        }

        for (
            int i = start; i < parenthesisList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(parenthesisList.get(i));
                dfs(input, parenthesisList, extractCount, visited, current, i+1);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}


