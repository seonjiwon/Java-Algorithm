import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> list1 = changeStrToList(str1);     
        List<String> list2 = changeStrToList(str2);     
        
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        
        int intersectionCount = 0;
        
        for(String s : list1) {
            if (list2.contains(s)) {
                intersectionCount++;
                list2.remove(s);
            }
        }
        
        // 2. 교집합을 제외했으니까 두개의 합이 합집합의 크기
        int unionCount = list1.size() + list2.size();
        
        double jacquard = (double) intersectionCount / unionCount;
        
    
        return (int) (jacquard * 65536);
    }
    
    private List<String> changeStrToList(String str) {
        List<String> list = new ArrayList<>();
        
        str = str.toLowerCase();
        
        for(int i = 0; i < str.length() - 1; i++){
            char first = str.charAt(i);
            char second = str.charAt(i+1);
            
            if(Character.isLetter(first) && Character.isLetter(second)) {
                list.add(String.valueOf(first) + String.valueOf(second));
            }
        } 
        
        return list;
    }
}