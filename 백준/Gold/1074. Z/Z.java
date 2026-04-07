import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int n = (int) Math.pow(2, N);

        System.out.println(recursive(n, r, c));

        br.close();
    }

    private static int recursive(int n, int r, int c) {
        int half = n / 2;
        int addNum = (int) Math.pow(n, 2) / 4;

        if (n == 1) {
            return 0;
        }

        if (r < n / 2) {
            // 1사분면
            if (c < n / 2) {
                return recursive(n / 2, r, c);
            }
            // 2사분면
            else {
                return addNum + recursive(n / 2, r, c - half);
            }
        } else {
            // 3사분면
            if (c < n / 2) {
                return addNum * 2 + recursive(n / 2, r - half, c);
            }
            // 4사분면
            else {
                return addNum * 3 + recursive(n / 2, r - half, c - half);
            }
        }
    }

}
