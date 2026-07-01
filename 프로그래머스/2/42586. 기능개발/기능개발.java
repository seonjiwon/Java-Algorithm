import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> countList = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int x = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            
            // 1. 업데이트
            for (int j = i; j < progresses.length; j++) {
                progresses[j] += speeds[j] * x;
            }
    
            
            // 2. check
            int count = 0;
            for (int j = i; j < progresses.length; j++) {
                if (progresses[j] < 100) {
                    break;
                }
                
                if (progresses[j] >= 100) {
                    // 완료된 작업까지 전진
                    i = j;
                    count++;
                }
            }
            
            countList.add(count);
        }
        
        int[] answer = countList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        
        return answer;
    }
}