import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // 정답 배열의 크기는 right - left + 1 개입니다.
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        
        // left부터 right까지 돌면서 해당 위치의 행, 열 번호를 구합니다.
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            
            // 행과 열 중 더 큰 값에 1을 더한 것이 해당 칸의 숫자입니다.
            answer[idx++] = (int) Math.max(row, col) + 1;
        }
        
        return answer;
    }
}