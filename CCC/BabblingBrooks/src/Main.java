import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Float> adj = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            adj.add(Float.parseFloat(br.readLine()));
        }
        String S = br.readLine();
        while(!S.equals("77")) {
            if(S.equals("99")) {
                int idx = Integer.parseInt(br.readLine())-1;
                float before = adj.remove(idx);
                float flow = before * Float.parseFloat(br.readLine())/100;
                adj.add(idx, before - flow);
                adj.add(idx, flow);
            } else {
                int idx = Integer.parseInt(br.readLine())-1;
                adj.add(idx, adj.remove(idx) + adj.remove(idx));
            }
            S = br.readLine();
//            for(Float x: adj) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
        }
        for(Float x: adj) {
            System.out.print(Math.round(x) + " ");
        }
    }
}
