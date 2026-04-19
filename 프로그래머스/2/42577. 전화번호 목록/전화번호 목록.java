import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Map<String, Boolean> map = new HashMap<>();
        for (String pb : phoneBook) {
            map.putIfAbsent(pb, true);
        }
        
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 1; j < phoneBook[i].length(); j++) {
                if(map.getOrDefault(phoneBook[i].substring(0,j), false)){
                    return false;   
                }
            }
        }
        return true;
    }
}