import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        while (N >= 5) {
            result += N / 5;
            N = N / 5;
        }


        System.out.println(result);
        br.close();
     }
}
