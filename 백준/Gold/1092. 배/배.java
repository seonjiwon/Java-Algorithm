import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        cranes.sort(Comparator.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        boxes.sort(Comparator.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0;
            for (int i = 0; i < cranes.size(); ) {
                if (boxIdx >= boxes.size()) break;

                if (cranes.get(i) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    i++;
                } else {
                    boxIdx++; 
                }
            }
            count++;
        }

        System.out.println(count);

        br.close();
    }
}
