import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 1. 한번 우선 전체 종류 구하기
        Map<Integer, Integer> toppings = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            toppings.put(topping[i], toppings.getOrDefault(topping[i], 0) + 1);
        }
        
        // 2. 앞에서 부터 하나씩 돌면서 
        // 남은 toppings > 0의 수 == 오른쪽 토핑의 수
        Set<Integer> toppingSet = new HashSet<>();
        
        int leftCount = 0;
        int rightCount = toppings.size();
        for(int i = 0; i < topping.length; i++) {
            int top = topping[i];
            int toppingCount = toppings.get(top);
            
            if (toppingCount == 1) {
                rightCount -= 1;
            }
            toppings.put(top, toppingCount - 1);
            
            
            if (!toppingSet.contains(top)) {
                toppingSet.add(top);
                leftCount++;
            } 
                
            if (leftCount == rightCount) {
                answer++;
            }
        }
        
        
        return answer;
    }
}