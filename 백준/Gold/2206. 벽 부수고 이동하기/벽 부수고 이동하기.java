import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        visited = new boolean[2][N][M];
        int result = bfs();

        System.out.println(result);
        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // startX, startY, crash, distance
        queue.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int k = current[2];
            int distance = current[3];

            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
//                    System.out.println("nx: " + nx + ", ny: " + ny);
                    if (k == 0) {
                        if (map[nx][ny] == 0 && !visited[0][nx][ny]) {
                            queue.offer(new int[]{nx, ny, k, distance + 1});
                            visited[0][nx][ny] = true;
                        } else if (map[nx][ny] == 1 && !visited[0][nx][ny]) {
                            queue.offer(new int[]{nx, ny, k + 1, distance + 1});
                            visited[0][nx][ny] = true;
                        }
                    } else {
                        if (map[nx][ny] == 0 && !visited[1][nx][ny]) {
                            queue.offer(new int[]{nx, ny, k, distance + 1});
                            visited[1][nx][ny] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
