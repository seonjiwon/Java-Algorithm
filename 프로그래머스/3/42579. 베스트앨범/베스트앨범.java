import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 데이터 세팅
        // genreMap: 각 장르별 [재생 횟수, 고유 번호] 리스트
        Map<String, List<int[]>> genreMap = new HashMap<>();
        // playSumMap: 각 장르별 총 재생 횟수
        Map<String, Integer> playSumMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.putIfAbsent(genres[i], new ArrayList<>());
            genreMap.get(genres[i]).add(new int[]{plays[i], i});
            
            playSumMap.put(genres[i], playSumMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 장르 정렬 (총 재생 횟수 내림차순)
        List<String> sortedGenres = new ArrayList<>(playSumMap.keySet());
        sortedGenres.sort((a, b) -> playSumMap.get(b) - playSumMap.get(a));

        // 3. 결과 생성
        List<Integer> resultList = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<int[]> songs = genreMap.get(genre);
            
            // 장르 내 노래 정렬: 1순위 재생수(내림차순), 2순위 고유번호(오름차순)
            songs.sort((a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });

            // 최대 2곡 추출
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                resultList.add(songs.get(i)[1]);
            }
        }

        // 4. List를 int[]로 변환하여 반환
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}