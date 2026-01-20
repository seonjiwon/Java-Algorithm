
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    private static int N = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");
        int source = Integer.parseInt(splits[0]);
        int target = Integer.parseInt(splits[1]);

        System.out.println(solution(source, target));

        br.close();
    }

    private static int solution(int source, int target) {
        int depth = 1;
        while (true) {
            if (target % 10 == 1) {
                target = target / 10;
            } else if (target % 2 == 0) {
                target = target / 2;
            } else {
                break;
            }
            if (target == 0) {
                break;
            }
            depth++;

            if (target == source) {
                return depth;
            }
        }

        return -1;
    }

}
