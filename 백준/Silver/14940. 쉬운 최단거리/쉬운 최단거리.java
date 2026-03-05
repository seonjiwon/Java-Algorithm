
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[][] distances;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        distances = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distances[i][j] = -1;
            }
        }

        int targetX = 0;
        int targetY = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int target = Integer.parseInt(st.nextToken());
                map[i][j] = target;

                if (target == 2) {
                    targetX = j;
                    targetY = i;
                    distances[i][j] = 0;
                }

                if (target == 0) {
                    distances[i][j] = 0;
                }
            }
        }

        bfs(targetX, targetY);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(distances[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 1});

        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[ny][nx] && map[ny][nx] != 0) {
                        distances[ny][nx] = distance;
                        queue.offer(new int[]{nx, ny, distance + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
