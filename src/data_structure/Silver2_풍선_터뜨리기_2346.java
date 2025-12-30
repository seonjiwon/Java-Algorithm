package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 1. 유형: 자료구조 / Deque 사용
 * 2. 로직: 큐를 돌려가며 자료를 탐색
 * 3.팁: 큐가 비어있는지 확인하는 로직이 들어가야 함
 */
public class Silver2_풍선_터뜨리기_2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.offer(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        System.out.println(solution(N, deque));

        br.close();
    }

    private static String solution(int n, Deque<int[]> deque) {
        StringBuilder sb = new StringBuilder();
        int move;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int position = current[0];
            move = current[1];
            sb.append(position).append(" ");
            if (deque.isEmpty()) break;

            if (move > 0) {
                for (int j = 0; j < move - 1; j++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int j = 0; j < Math.abs(move); j++) {
                    deque.offerFirst(deque.pollLast());
                }
            }

        }

        return sb.toString();
    }
}
