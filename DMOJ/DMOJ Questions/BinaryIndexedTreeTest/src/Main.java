import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[] bit;
    public static int[] arr;
    public static long[] freqbit;

    public static void c(int x, int v) {
        while(x <= freqbit.length) {
            freqbit[x] += v;
            x += (x & -x);
        }
    }

    public static void C(int x, int v) {
        while(x <= bit.length) {
            bit[x] += v;
            x += (x & -x);
        }
    }

    public static long s(int i) {
        long sum = 0;
        while(i > 0) {
            sum += freqbit[i];
            i -= (i & -i);
        }
        return sum;
    }

    public static long S(int l, int r) {
        long sum = 0;
        while(r > 0) {
            sum += bit[r];
            r -= (r & -r);
        }
        while(l > 0) {
            sum -= bit[l];
            l -= (l & -l);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new int[N+1]; bit = new long[N+1]; freqbit = new long[100001];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            C(i, arr[i]);
            c(arr[i], 1);
        }
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "C":
                    int X = Integer.parseInt(st.nextToken());
                    int V = Integer.parseInt(st.nextToken());
                    int val = V - arr[X];
                    C(X, val);
                    c(arr[X], -1);
                    c(V, 1);
                    arr[X] = V;
                    break;
                case "S":
                    System.out.println(S(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
                    break;
                case "Q":
                    System.out.println(s(Integer.parseInt(st.nextToken())));
                    break;
            }
        }
    }
}
