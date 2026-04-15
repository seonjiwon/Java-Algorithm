import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer += entry.getKey();
            }
        }
        
        return answer;
    }
}