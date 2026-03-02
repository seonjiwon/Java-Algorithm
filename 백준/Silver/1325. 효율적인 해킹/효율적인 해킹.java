import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] link;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        link = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            link[v].add(u);
        }

        int maxCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            int count = bfs(i);
            if (count > maxCount) {
                while (!pq.isEmpty()) {
                    pq.poll();
                }
                pq.offer(i);
                maxCount = count;
            } else if (count == maxCount) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);

        br.close();
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Integer u = queue.poll();

            for (int v : link[u]) {
                if (!visited[v]) {
                    count++;
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }

        return count;
    }
}
