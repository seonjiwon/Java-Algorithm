import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(array, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(array[0][1]);

        for (int i = 1; i < N; i++) {
            int minEndTime = pq.peek();

            if (minEndTime <= array[i][0]) {
                pq.poll();
            }

            pq.offer(array[i][1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}
