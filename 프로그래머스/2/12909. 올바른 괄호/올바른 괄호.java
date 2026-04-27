import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? true : false;
    }
}