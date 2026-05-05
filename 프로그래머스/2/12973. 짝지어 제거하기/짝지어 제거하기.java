import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        
        Stack<Character> stack = new Stack<>();
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if(!stack.isEmpty()){
                if (stack.peek() == chars[i]) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(chars[i]);
        }
        
        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}