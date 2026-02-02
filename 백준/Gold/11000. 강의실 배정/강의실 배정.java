import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<int[]> timeLines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            timeLines.add(new int[]{start, end});
        }

        timeLines.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(timeLines.get(0)[1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= timeLines.get(i)[0]) {
                pq.poll();
            }
            pq.offer(timeLines.get(i)[1]);
        }

        System.out.println(pq.size());
        br.close();
    }

}
