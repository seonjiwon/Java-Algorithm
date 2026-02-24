
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] honeys = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int honey = Integer.parseInt(st.nextToken());
            honeys[i] = honey;
        }

        long[][] sum = new long[2][N];
        sum[0][0] = honeys[0];
        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + honeys[i];
        }

        sum[1][0] = honeys[N - 1];
        for (int i = 1; i < N; i++) {
            sum[1][i] = sum[1][i - 1] + honeys[N - i - 1];
        }

        long max = 0;

        for (int i = 1; i <= N - 2; i++) {
            long temp = (sum[0][N - 1] - sum[0][i]) + (sum[0][N - 1] - honeys[0]) - honeys[i];
            max = Math.max(max, temp);
        }

        for (int i = 1; i <= N - 2; i++) {
            long temp = (sum[1][N - 1] - sum[1][i]) + (sum[1][N - 1] - sum[1][0]) - honeys[N-i-1];;
            max = Math.max(max, temp);
        }

        for (int i = 1; i <= N - 2; i++) {
            long temp = sum[0][i] + sum[1][N - i - 1] - sum[0][0] - sum[1][0];
            max = Math.max(max, temp);
        }

        System.out.println(max);

        br.close();
    }
}
