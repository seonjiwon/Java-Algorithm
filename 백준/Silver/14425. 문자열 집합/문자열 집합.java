import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] sources = new String[N];
        for (int i = 0; i < N; i++) {
            sources[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            for (String source : sources) {
                if (target.equals(source)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

        br.close();
    }

}
