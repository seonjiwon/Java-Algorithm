import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String trimmed = s.substring(2, s.length() - 2);
        String[] groups = trimmed.split("\\},\\{");
        Arrays.sort(groups, Comparator.comparingInt(String::length));
        
        LinkedHashSet<Integer> seen = new LinkedHashSet<>();

    
        for(String group : groups) {
            Arrays.stream(group.split(","))
                .map(Integer::parseInt)
                .forEach(seen::add);   
        }
        
        answer = seen.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}