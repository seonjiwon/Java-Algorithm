import java.util.*;

// citations중 h번 이상 인용된게 h개
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(citations);
        
        System.out.println(Arrays.toString(citations));
        
        for (int i = 0; i < citations.length; i++) {
            // i + 1 = h 번 이상 인용된 논문의 수
            // citations[i] = h번 이상 인용되었다.
            System.out.println("i: " + i + ", " + citations[citations.length - 1 - i]);
            if (i + 1 <= citations[citations.length - 1 - i]) {
                answer = i + 1;
            }
        }
        
        
        
        return answer;
    }
}