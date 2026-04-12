import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[][] flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        flowers = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDays = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDays = Integer.parseInt(st.nextToken());

            flowers[i][0] = startMonth * 100 + startDays;
            flowers[i][1] = endMonth * 100 + endDays;
        }

        Arrays.sort(flowers, (o1, o2) -> o1[0] - o2[0]);

        int curEnd = 301;
        int maxEnd = 0;
        int i = 0;
        int count = 0;

        // 마지막이 1130 이하인 지점
        while (curEnd <= 1130) {
            // 꽃이 지는 날이 현재 종료일 보다 작은 것들
            while (i < N && flowers[i][0] <= curEnd) {
                // 최대 종료일
                maxEnd = Math.max(maxEnd, flowers[i][1]);
                i++;
            }

            // 최대 종료일이 현재 종료일 보다 낮으면 안됨
            if (maxEnd <= curEnd) {
                System.out.println(0);
                return;
            }

            curEnd = maxEnd;
            count++;
        }

        System.out.println(count);

        br.close();
    }
}
