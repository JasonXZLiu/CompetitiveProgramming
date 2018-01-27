import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(x[0]);
        for (int i = 1; i < N; i++)
        {
            if (x[i] < lis.get(0)) {lis.remove(0); lis.add(0, x[i]);}
            else if (x[i] > lis.get(lis.size()-1))  lis.add(x[i]);
            else {
                int idx = binarySearch(lis, -1, lis.size()-1, x[i]);
                lis.remove(idx); lis.add(idx, x[i]);
            }
        }
        System.out.println(lis.size());
    }

    static int binarySearch(ArrayList<Integer> adj, int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (adj.get(m) >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }
}
