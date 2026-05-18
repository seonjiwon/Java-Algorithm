import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        int[] newElements = new int[elements.length * 2];
        
        for(int i = 0; i < elements.length * 2; i++) {
            newElements[i] = elements[i % elements.length];
        }
        
        // i = 길이
        int sum = 0;
        for (int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                for (int p = j; p < j + i; p++) {
                    sum += newElements[p];
                }
                set.add(sum);
                sum = 0;
            }
        }
        
        answer = set.size();
        return answer;
    }
}