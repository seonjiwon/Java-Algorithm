import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        int count = 0;
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    maxSize = Math.max(maxSize, bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
        br.close();
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        size++;
                    }
                }
            }
        }

        return size;
    }
}
