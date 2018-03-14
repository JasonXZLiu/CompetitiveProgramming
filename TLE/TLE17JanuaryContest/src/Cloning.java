import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by jason_001 on 1/26/2018.
 */
public class Cloning {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); String T = br.readLine();
        ArrayList<String> str = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        long MAX = Long.MIN_VALUE;
        long[] Q = new long[N];
        for(int i = 0; i < N; i++) {
            long tmp = Long.parseLong(br.readLine())-1;
            Q[i] = tmp; MAX = Math.max(MAX, tmp);
        }
        long length = 0; int count = 0; int idx = 0;
        str.add("0");
        while(length < MAX) {
            if(count >= str.get(idx).length()) {
                count -= str.get(idx).length();
                idx++;
            }
            int tmp = Integer.parseInt(str.get(idx).substring(count,count+1));
            if(tmp == 0) {
                str.add(S); length += S.length();
            } else {
                str.add(T); length += T.length();
            }
            count++;
        }
        for(int i = 0; i < N; i++) {
            int id = 0; long x = Q[i];
            for(int j = 0; j < str.size() && x - str.get(j).length() >= 0; j++){
                x -= str.get(j).length();
//                System.out.println(x + " - " + str.get(j).length());
                id++;
            }
            int b = (int) (x);
            System.out.println(str.get(id).substring(b, b+1));
        }
    }
}
