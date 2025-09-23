import java.util.*;
import java.io.*;

public class Main {

    static int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = solution(N);

        System.out.println(result);

        br.close();
    }

    private static int solution(int n) {
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] += dp[i - 1][8] % mod;
                } else {
                    dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;;
                }

            }
        }

        int result = 0;

        for (int i : dp[n]) {
            result = (result + i) % mod;
        }

        return result % mod;
    }
}
