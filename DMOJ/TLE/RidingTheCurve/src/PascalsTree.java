import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/22/2017.
 */
public class PascalsTree {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        Long N = Long.parseLong(n); BigInteger M = new BigInteger(st.nextToken());
        Stack<Long> Q = new Stack<>(); long num = Math.round(Long.parseLong(n)/2);
        BigInteger B = new BigInteger("1"); long tmp;
        for(Integer i = 1; i <= num; i++) {
            if(B.compareTo(M) == 1) tmp = Long.parseLong(B.remainder(M).toString());
            else if(B.equals(M)) tmp = 0;
            else tmp = Long.parseLong(B.remainder(M).toString());
            System.out.println(tmp);
            Q.add(tmp);
            B = B.multiply(new BigInteger(N.toString())).divide(new BigInteger(i.toString()));
            N--;
        }
        Q.add(Long.parseLong(B.remainder(M).toString()));
        while(!Q.isEmpty()) {System.out.println(Q.pop());}
    }
}
