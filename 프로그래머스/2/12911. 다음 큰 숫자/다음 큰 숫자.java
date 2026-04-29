import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String temp = Integer.toBinaryString(n);

        String newTemp = temp.replace("1", "");
        int nLength = temp.length() - newTemp.length();
                
        for(int i = n + 1; i < 1_000_000; i++) {
            String s = Integer.toBinaryString(i);
            String newS = s.replace("1", "");
            
            if (s.length() - newS.length() == nLength) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}