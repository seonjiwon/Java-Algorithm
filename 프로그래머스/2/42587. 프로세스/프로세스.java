import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities) {
            pq.offer(p);
        }
        
        
        int i = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            int priority = pq.poll();
            
            while (true) {
                if (priorities[i % priorities.length] == priority) {
                    count++;
                    System.out.println("priority: " + priority + ", count: " + count + ", i % priorities.length: " + i % priorities.length);
                    if (i % priorities.length == location) {
                        answer = count;
                    }
                    i++;
                    break;
                }
                i++;
            }
            
        }
        
        return answer;
    }
}