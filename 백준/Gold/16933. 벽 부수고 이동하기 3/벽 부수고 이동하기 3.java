import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 조건: - K개의 벽 낮에만 부술 수 있음. - 가만히 있을 수도 있음 이 경우 움직인걸로 처리. - 벽은 낮에만 부술 수 있음
 */
public class Main {

    static int N, M, K;
    static int[][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        visited = new boolean[K + 1][2][N][M];
        int result = bfs();

        System.out.println(result);

        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // x, y, k, distance, date(0: 낮, 1: 밤)
        queue.offer(new int[]{0, 0, 0, 1, 0});
        visited[0][0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int k = current[2];
            int distance = current[3];
            int date = current[4];

            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            // 밤인 경우
            if (date == 1) {
                queue.offer(new int[]{x, y, k, distance + 1, 1 - date});
                visited[k][date][x][y] = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 아직 벽을 더 부술 수 있는 경우
                if (k < K) {
                    // 벽이 아닐때
                    if (map[nx][ny] == 0 && !visited[k][date][nx][ny]) {
                        queue.offer(new int[]{nx, ny, k, distance + 1, 1 - date});
                        visited[k][date][nx][ny] = true;
                    }
                    // 벽일 때
                    else if (map[nx][ny] == 1 && date == 0 && !visited[k][date][nx][ny]) {
                        queue.offer(new int[]{nx, ny, k + 1, distance + 1, 1 - date});
                        visited[k + 1][date][nx][ny] = true;
                    }
                } else {
                    if (map[nx][ny] == 0 && !visited[k][date][nx][ny]) {
                        queue.offer(new int[]{nx, ny, k, distance + 1, 1 - date});
                        visited[k][date][nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}
