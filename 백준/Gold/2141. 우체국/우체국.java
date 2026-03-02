
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [백준 2141] 우체국 (Gold 4)
 *
 * 핵심 패턴: 절댓값 거리 합 최소 → 가중 중앙값
 *
 * 접근 과정:
 * 1. 브루트포스 O(N^2) → N=100,000이므로 시간 초과
 * 2. 수식 전개 (누적합/누적곱) O(N log N)
 *    → 로직은 맞으나 중간 계산에서 long 오버플로우
 * 3. 가중 중앙값 O(N log N) → 채택
 *    → 정렬 후 인구 누적합이 전체의 절반 이상 되는 첫 마을
 *
 * 시간복잡도: O(N log N) - 정렬
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] villages = new int[N][2];

        long totalHuman = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            villages[i][0] = Integer.parseInt(st.nextToken());

            int humanCount = Integer.parseInt(st.nextToken());
            villages[i][1] = humanCount;
            totalHuman += humanCount;
        }

        // 1. 정렬
        Arrays.sort(villages, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 2. 인구의 중앙값 찾가
        long median = (totalHuman+1) / 2;
        long medianCount = 0;
        for (int i = 0; i < N; i++) {
            int humanCount = villages[i][1];
            medianCount += humanCount;

            if (medianCount >= median) {
                System.out.println(villages[i][0]);
                break;
            }
        }

        br.close();
    }
}
