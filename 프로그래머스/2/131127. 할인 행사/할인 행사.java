import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();                
        int left = 0;
        int right = 0;

        while (right < discount.length) {
            map.put(discount[right], map.getOrDefault(discount[right], 0) + 1);
        
            if (right - left + 1 == 10) {
                boolean flag = true;
                for (int i = 0; i < want.length; i++) {
                    
                    if (map.getOrDefault(want[i], 0) != number[i]) {
                        flag = false;
                        break;
                    }
                }   
                
                if(flag) {
                    answer++;
                }
                
                map.put(discount[left], map.get(discount[left]) - 1);
                left++;
            }
            right++;
        }
        
        return answer;
    }
}