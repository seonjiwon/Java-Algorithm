import java.util.*;
import java.io.*;

public class Main {
    static Integer[] dp;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new Integer[N + 1];

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        
        System.out.println(solution(N));

        br.close();
    }

    private static int solution(int n) {
        // 아직 탐색하지 않는 n 번째 계단 일 경우
        if (dp[n] == null) {
            dp[n] = Math.max(solution(n - 2), solution(n - 3) + stairs[n - 1]) + stairs[n];
        }

        return dp[n];
    }
}
