
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i][0] = start;
            lectures[i][1] = end;
        }
        Arrays.sort(lectures, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        Stack<Integer> stack = new Stack<>();
        stack.push(lectures[0][1]);
        for (int i = 1; i < N; i++) {
            Integer lastIndex = stack.peek();
            if (lastIndex <= lectures[i][0]) {
                stack.push(lectures[i][1]);
            }
        }

        System.out.println(stack.size());

        br.close();
    }
}
