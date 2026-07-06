import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Map<String, Integer> map = new LinkedHashMap<>(cacheSize, 0.75f, true);
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            // 캐시 히트
            if(map.containsKey(city)) {
                answer += 1;
                map.put(city, i);
                continue;
            }
            
            // 캐시 미스
            if(map.size() < cacheSize) { // 캐시에 유휴 공간이 있는 경우
                map.put(city, i);
                answer += 5;
            } else { // 캐시가 가득 찬 경우 value 기준 제일 오래된거를 버림
                String oldestKey = map.keySet().iterator().next();
                map.remove(oldestKey);
                map.put(city, i);
                answer += 5;
            }
        }
        
        return answer;
    }
}