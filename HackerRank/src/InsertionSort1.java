import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class InsertionSort1 {

    public static void print(int[] arr) {
        for(int i = 1; i <= arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = Integer.MIN_VALUE; arr[N] = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N-1; i++) arr[i] = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        while(true) {
            if(arr[N-1] <= E && E <= arr[N+1]) {arr[N] = E; break;}
            else arr[N] = arr[N-1];
            N--;
            print(arr);
        }
        print(arr);
    }
}
