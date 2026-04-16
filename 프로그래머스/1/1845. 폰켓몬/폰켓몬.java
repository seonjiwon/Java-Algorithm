import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(String.valueOf(nums[i]), map.getOrDefault(nums[i], 0) + 1);
        }
        
        int selectSize = nums.length / 2;
        int mapSize = map.size();
        
        answer = selectSize > mapSize ? mapSize : selectSize;
        return answer;
    }
}