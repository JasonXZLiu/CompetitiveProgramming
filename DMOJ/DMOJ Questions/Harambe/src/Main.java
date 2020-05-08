import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/18/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); int upperCase = 0; int lowerCase = 0;
        for (int k = 0; k < input.length(); k++) {
            if (Character.isUpperCase(input.charAt(k))) upperCase++;
            if (Character.isLowerCase(input.charAt(k))) lowerCase++;
        }
        if(upperCase == lowerCase) System.out.println(input);
        else if (upperCase > lowerCase) System.out.println(input.toUpperCase());
        else System.out.println(input.toLowerCase());
    }
}
