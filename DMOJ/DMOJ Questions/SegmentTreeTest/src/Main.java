import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static Segment[] seg;
    public static int[] arr;

    static int GCD(int a, int b) {
        int rem = a % b;
        if(rem == 0) return b;
        else return GCD(b, rem);
    }

    static void build(int root, int left, int right) {
        seg[root] = new Segment(left, right, 0, 0, 0);
        if(left == right) {
            seg[root].min = arr[left];
            seg[root].gcd = arr[left];
            seg[root].num = 1;
        }
        else {
            int mid = (left + right) / 2;
            build(2 * root, left, mid); build(2 * root + 1, mid + 1, right);
            seg[root].min = Math.min(seg[2 * root].min, seg[2 * root + 1].min);
            seg[root].gcd = GCD(seg[2 * root].gcd, seg[2 * root + 1].gcd);
            if(seg[root].gcd == seg[2 * root].gcd) seg[root].num += seg[2 * root].num;
            if(seg[root].gcd == seg[2 * root + 1].gcd) seg[root].num += seg[2 * root + 1].num;
        }
    }
    static void C(int root, int x, int v) {
        seg[root] = new Segment(seg[root].left, seg[root].right, 0, 0, 0);
        if(seg[root].left == seg[root].right && seg[root].left == x) {
            seg[root].min = v;
            seg[root].gcd = v;
            seg[root].num = 1;
        }
        else {
            int mid = (seg[root].left + seg[root].right) / 2;
            if(x <= mid) C(2 * root, x, v);
            else C(2 * root + 1, x, v);
            seg[root].min = Math.min(seg[2 * root].min, seg[2 * root + 1].min);
            seg[root].gcd = GCD(seg[2 * root].gcd, seg[2 * root + 1].gcd);
            if(seg[root].gcd == seg[2 * root].gcd) seg[root].num += seg[2 * root].num;
            if(seg[root].gcd == seg[2 * root + 1].gcd) seg[root].num += seg[2 * root + 1].num;
        }
    }
    static int M(int root, int left, int right) {
        if(seg[root].left == left && seg[root].right == right) return seg[root].min;
        else {
            int mid = (seg[root].left + seg[root].right) / 2;
            if(right <= mid) return M(2 * root, left, right);
            else if(left > mid) return M(2 * root + 1, left, right);
            else return Math.min(M(2 * root, left, mid), M(2 * root + 1, mid + 1, right));
        }
    }
    static int G(int root, int left, int right) {
        if(seg[root].left == left && seg[root].right == right) return seg[root].gcd;
        else {
            int mid = (seg[root].left + seg[root].right) / 2;
            if(right <= mid) return G(2 * root, left, right);
            else if(left > mid) return G(2 * root + 1, left, right);
            else return GCD(G(2 * root, left, mid), G(2 * root + 1, mid + 1, right));
        }
    }
    static int Q(int root, int left, int right, int GCD) {
        if(seg[root].left == left && seg[root].right == right) {
            if(seg[root].gcd == GCD) return seg[root].num;
            else return 0;
        }
        else {
            int mid = (seg[root].left + seg[root].right) / 2;
            if(right <= mid) return Q(2 * root, left, right, GCD);
            else if(left > mid) return Q(2 * root + 1, left, right, GCD);
            else {
                return(Q(2 * root, left, mid, GCD) + Q(2 * root + 1, mid + 1, right, GCD));
            }
        }
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        seg = new Segment[N * 5]; arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        build(1, 1, N);
        for(int t = 0; t < M; t++) {
            int A = 0, B = 0;
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            switch (func) {
                case "C":
                    C(1, A, B);
                    break;
                case "M":
                    System.out.println(M(1, A, B));
                    break;
                case "G":
                    System.out.println(G(1, A, B));
                    break;
                case "Q":
                    System.out.println(Q(1, A, B, G(1, A, B)));
                    break;
                default:
                    break;
            }
        }
    }

    static class Segment {
        public int left, right, min, gcd, num;

        Segment (int left, int right, int min, int gcd, int num) {
            this.left = left; this.right = right; this.min = min; this.gcd = gcd; this.num = num;
        }
    }
}
