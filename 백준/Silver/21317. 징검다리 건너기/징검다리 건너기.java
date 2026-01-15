
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] energy = new int[N][2];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int large = Integer.parseInt(st.nextToken());
            energy[i][0] = small;
            energy[i][1] = large;
        }

        K = Integer.parseInt(br.readLine());

        System.out.println(solution(energy));

        br.close();
    }

    private static int solution(int[][] arr) {
        int[][] dp = new int[2][N+1];
        Arrays.fill(dp[0], 200000);
        Arrays.fill(dp[1], 200000);

        dp[0][1] = 0;

        if (N >= 2) {
            dp[0][2] = arr[0][0];
        }
        if (N >= 3) {
            dp[0][3] = Math.min(dp[0][2] + arr[1][0], dp[0][1] + arr[0][1]);
        }

        for (int i = 3; i <= N; i++) {
            dp[0][i] = Math.min(dp[0][i-1] + arr[i-2][0], dp[0][i-2] + arr[i-3][1]);
            dp[1][i] = Math.min(dp[1][i-1] + arr[i-2][0], Math.min(dp[1][i-2] + arr[i-3][1], dp[0][i-3] + K));
        }
        return Math.min(dp[0][N], dp[1][N]);
    }

}
