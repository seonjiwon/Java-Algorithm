import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 1. s의 길이 만큼 회전을 시킨다
        for (int i = 0;  i < s.length(); i++) {
            Stack<String> stack = new Stack<>();
            
            // 2. s의 i번 째 위치 부터 시작
            for (int j = i; j < i + s.length(); j++) {
                String ch = String.valueOf(s.charAt(j % s.length()));
                if (!stack.isEmpty()) {
                    String peek = stack.peek();
                    if ((peek.equals("{") && ch.equals("}")) || 
                        (peek.equals("(") && ch.equals(")")) || 
                        (peek.equals("[") && ch.equals("]"))) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(ch);
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}