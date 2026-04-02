import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] alphabets = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o",
            "p", "a", "s", "d", "f", "g", "h", "j", "k", "l",
            "z", "x", "c", "v", "b", "n", "m"};

        Map<String, int[]> map = new HashMap<>();

        int dx = 0;
        int dy = 0;
        for (int i = 0; i < alphabets.length; i++) {
            map.put(alphabets[i], new int[]{dx, dy});

            dy++;

            if (i == 9) {
                dx = 1;
                dy = 0;
            }

            if (i == 18) {
                dx = 2;
                dy = 0;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        String left = st.nextToken();
        String right = st.nextToken();

        int[] leftLocation = map.get(left);
        int[] rightLocation = map.get(right);

        String line = br.readLine();

        int result = 0;

        String[] vowels = {"b", "n", "m", "h", "j", "k", "l", "y", "u", "i", "o", "p"};

        for (int i = 0; i < line.length(); i++) {
            String target = String.valueOf(line.charAt(i));
            int[] targetLocation = map.get(target);

            boolean flag = false;

            for (int j = 0; j < vowels.length; j++) {
                if (target.equals(vowels[j])) {
                    flag = true;
                }
            }

            if (flag) {
                result += Math.abs(targetLocation[0] - rightLocation[0]) + Math.abs(
                    targetLocation[1] - rightLocation[1]);
                rightLocation = new int[]{targetLocation[0], targetLocation[1]};
            } else {
                result += Math.abs(targetLocation[0] - leftLocation[0]) + Math.abs(
                    targetLocation[1] - leftLocation[1]);
                leftLocation = new int[]{targetLocation[0], targetLocation[1]};
            }

            result++;
        }


        System.out.println(result);
        br.close();
    }
}
