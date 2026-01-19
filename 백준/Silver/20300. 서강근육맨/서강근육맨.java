import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeMap<Long, Long> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            Long n = Long.parseLong(st.nextToken());
            map.put(n, map.getOrDefault(n, 0L) + 1);
        }

        System.out.println(solution(map));

        br.close();
    }

    private static Long solution(TreeMap<Long, Long> map) {
        if (N == 1) {
            return map.firstKey();
        }

        Long maxValue = 0L;
        if (N % 2 == 1) {
            // 1. 가장 큰 값
            Entry<Long, Long> firstEntry = map.pollFirstEntry();
            maxValue = firstEntry.getKey();
        }

        Long M = 0L;
        while (!map.isEmpty()) {
            Entry<Long, Long> firstEntry = map.pollFirstEntry();
            Entry<Long, Long> lastEntry = map.pollLastEntry();

            M = Math.max(M, firstEntry.getKey() + lastEntry.getKey());
        }

        return maxValue > M ? maxValue : M;
    }

}
