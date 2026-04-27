import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] chars = s.toCharArray();
        StringBuilder tempSb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append(tempSb.toString());
                tempSb.setLength(0);
                sb.append(" ");
                continue;
            }
            
            if (tempSb.length() == 0) {  
                tempSb.append(String.valueOf(chars[i]).toUpperCase());
            } else {
                tempSb.append(String.valueOf(chars[i]).toLowerCase());
            }
        }
        
        sb.append(tempSb.toString());
        
        return sb.toString();
    }
}