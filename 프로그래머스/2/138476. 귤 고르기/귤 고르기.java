import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());
        
        int sumCount = 0;
        for(int i = 0; i < counts.size(); i++) {
            sumCount += counts.get(i);
            
            if (sumCount >= k) {
                answer++;
                break;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}