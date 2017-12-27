import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        E[] adj = new E[1001];
        for(int i = 0; i < 1001; i++) {
            adj[i] = new E(i, 0);
        }
        for(int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            adj[A].freq++;
        }
        Arrays.sort(adj);
        int i = checkMax(adj);
        System.out.println(checkMin(adj, i, adj[i].idx));
    }

    public static int checkMin(E[] adj, int i, int boop) {
        int max = 0;
        if(i != 1000) {
            int freq = adj[i].freq;
            while(i <= 1000 && adj[i].freq == freq) {
                max = Math.max(max, Math.abs(boop - adj[i].idx));
                i++;
            }
        } else {
            i--;
            int freq = adj[i].freq;
            while (i > 0 && adj[i].freq == freq) {
                max = Math.max(max, Math.abs(boop - adj[i].idx));
                i--;
            }
        }
       return max;
    }

    public static int checkMax(E[] adj) {
        int i = 1000;  int max = adj[999].idx;
        while(adj[i-1].freq == adj[i].freq) {
            max = Math.max(max, Math.abs(max-adj[i].idx));
            i--;
        }
        return i;
    }

    static class E implements Comparable<E> {
        public int idx, freq;
        E(int idx, int freq) {this.idx = idx; this.freq = freq;}

        @Override
        public int compareTo(E o) {
            if(freq > o.freq) return 1;
            else if (freq < o.freq) return -1;
            else {
                if(idx > o.idx) return -1;
                else return 1;
            }
        }
    }
}
