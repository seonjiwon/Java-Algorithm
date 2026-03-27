import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "Fail" : result);

        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // 시작 x, 시작 y, 칼 소유 여부
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int sword = current[2];
            int count = current[3];

            if (count > T) {
                break;
            }

            if (x == N - 1 && y == M - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (sword == 0) {
                        if (map[nx][ny] == 0 && !visited[0][nx][ny]) {
                            queue.offer(new int[]{nx, ny, sword, count + 1});
                            visited[0][nx][ny] = true;
                        } else if (map[nx][ny] == 2 && !visited[0][nx][ny]) {
                            queue.offer(new int[]{nx, ny, sword + 1, count + 1});
                            visited[0][nx][ny] = true;
                        }
                    } else {
                        if (!visited[1][nx][ny]) {
                            queue.offer(new int[]{nx, ny, sword, count + 1});
                            visited[1][nx][ny] = true;
                        }
                    }
                }
            }

        }

        return -1;
    }
}
