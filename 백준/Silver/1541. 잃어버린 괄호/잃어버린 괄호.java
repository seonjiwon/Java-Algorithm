
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // - 나오면 - 나오기 전까지 다 더하기
        // + 이면 그냥 더하기

        String[] split = input.split("-");
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            int temp = 0;
            String previous = "";
            for (int j = 0; j < str.length(); j++) {
                String ch = String.valueOf(str.charAt(j));
                if (ch.equals("+") || ch.equals("-")) {
                    temp = ch.equals("+") ? temp + Integer.parseInt(previous) : temp - Integer.parseInt(previous);
                    previous = "";
                }
                previous = previous.concat(ch);
            }

            temp += Integer.parseInt(previous);

//            System.out.println(result + ", " + temp);
            result += i == 0 ? temp : -temp;
        }

        System.out.println(result);

        br.close();
    }

}
