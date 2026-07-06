import java.util.*;

class Solution {
    static int n;
    static int m;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[][] move;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        move = new int[n][m];
        
        answer = bfs(maps, 0, 0);
        
        return answer;
    }
    
    private int bfs(int[][] maps, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 1});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int mv = current[2];
            
            if(x == n - 1 && y == m - 1) {
                return move[x][y] + 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        move[nx][ny] = mv;
                        queue.offer(new int[]{nx, ny, mv + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}