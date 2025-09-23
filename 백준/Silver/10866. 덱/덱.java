import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<String> queue = new ArrayDeque<>();

        while (N-- > 0) {
            String[] split = br.readLine().split(" ");
            switch (split[0]) {
                case "push_front":
                    queue.offerFirst(split[1]);
                    break;
                case "push_back":
                    queue.offer(split[1]);
                    break;
                case "pop_front":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                case "pop_back":
                    sb.append(queue.isEmpty() ? -1 : queue.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}
