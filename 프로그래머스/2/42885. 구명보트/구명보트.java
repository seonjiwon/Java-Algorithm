import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            // 가장 무거운 사람
            int weight = people[right];
            
            if(limit - weight >= people[left]) {
                left++;
            }
            
            answer++; 
            right--;
        }
        
        return answer;
    }
}