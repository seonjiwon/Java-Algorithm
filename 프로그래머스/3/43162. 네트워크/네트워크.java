import java.util.*;
import java.util.stream.*;

class Solution {
    
    static boolean[] visited;
    static List<Integer>[] link;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        link = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            link[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    link[i+1].add(j+1);
                }
            }
        }
        
        visited = new boolean[n+1];
        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                bfs(i);    
                answer++;
            }
        }
        
        Arrays.stream(link)
            .forEach(s -> System.out.println(s.toString()));
        
        return answer;
    }
    
    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int v : link[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        
    }
}