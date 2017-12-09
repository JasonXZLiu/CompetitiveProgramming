import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int Q;
    public static int[] reward = {30, 60, 9}, boops = {35, 100, 10}, mach;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        mach = new int[]{Integer.parseInt(br.readLine())+1, Integer.parseInt(br.readLine())+1, Integer.parseInt(br.readLine())+1};
        long cnt = 0; int i = 0;
        while(Q > 0) {
            Q--;
            cnt++;
            doop(i);
            if(i == 2) i = 0;
            else i++;
        }
        System.out.println("Martha plays " + cnt + " times before going broke.");
    }

    public static void doop(int i) {
        if(mach[i] == boops[i]) {
            Q += reward[i];
            mach[i]=1;
        } else mach[i]++;
    }
}
