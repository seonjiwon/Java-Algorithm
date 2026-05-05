class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        

        int border = brown - 4;
        int x = (border - 2) / 2;
        int y = 1;
        
        while(true) {
            if (x * y == yellow) {
                break;
            }
            x--;
            y++;
        }
        
        answer[0] = x + 2;
        answer[1] = y + 2;
        
        return answer;
    }
}