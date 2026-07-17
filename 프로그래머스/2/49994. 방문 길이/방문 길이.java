import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> visitedEdges = new HashSet<>();

        int x = 0, y = 0;
        Map<Character, int[]> move = new HashMap<>();
        move.put('U', new int[]{0, 1});
        move.put('D', new int[]{0, -1});
        move.put('R', new int[]{1, 0});
        move.put('L', new int[]{-1, 0});

        for (char c : dirs.toCharArray()) {
            int[] d = move.get(c);
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue; 
            }

            String edge1 = x + "," + y + "->" + nx + "," + ny;
            String edge2 = nx + "," + ny + "->" + x + "," + y;

            if (!visitedEdges.contains(edge1)) {
                visitedEdges.add(edge1);
                visitedEdges.add(edge2);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}