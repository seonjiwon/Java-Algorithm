import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 1. arr1의 row
        for (int i = 0; i < arr1.length; i++) {
            
            // 2. arr2의 row
            for (int k = 0; k < arr2[0].length; k++) {
                
                // 3. 곱할 수
                for(int j = 0; j < arr1[0].length; j++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        
        return answer;
    }
}