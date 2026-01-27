import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    StringBuilder maxResult = new StringBuilder();
    StringBuilder minResult = new StringBuilder();
    int mCount = 0;

    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);

        if (c == 'K') {
            maxResult.append("5");
            for (int j = 0; j < mCount; j++) maxResult.append("0");
            
            if (mCount > 0) {
                minResult.append("1");
                for (int j = 0; j < mCount - 1; j++) minResult.append("0");
            }
            minResult.append("5");
            mCount = 0;
        } else {
            mCount++;
        }
    }
    
    if (mCount > 0) {
        for (int j = 0; j < mCount; j++) maxResult.append("1");
        
        minResult.append("1");
        for (int j = 0; j < mCount - 1; j++) minResult.append("0");
    }
    
    System.out.println(maxResult);
    System.out.println(minResult);

    br.close();
}
}
