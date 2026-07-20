import java.util.*;

class Solution {
    char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    int[] rate = {781, 156, 31, 6, 1};
    public int solution(String word) {
        int answer = 0;
        
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            for (int j  = 0; j < vowel.length; j++) {
                
                if (words[i] == vowel[j]) {
                    answer += (rate[i] * j) + 1;
                    break;
                }
            }
        }      
        
        return answer;
    }
}