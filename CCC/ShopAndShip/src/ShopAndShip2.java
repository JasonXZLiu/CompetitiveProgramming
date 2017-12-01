import java.util.*;
import java.io.*;

class ShopAndShip2 {

    public static void main(String[]args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(bf.readLine());
        int [][] ai = new int [N][N];
        for(int i = 0; i < N; i++) Arrays.fill(ai[i], Integer.MAX_VALUE);
        Integer T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer (bf.readLine());
            Integer x = Integer.parseInt(st.nextToken());
            Integer y = Integer.parseInt(st.nextToken());
            Integer C = Integer.parseInt(st.nextToken());
            ai[x - 1][y - 1] = ai[y - 1][x - 1] = C;
        }
        ArrayList<Integer> city = new ArrayList<Integer>();
        ArrayList<Integer> length = new ArrayList<Integer>();
        Integer K = Integer.parseInt(bf.readLine());
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer (bf.readLine());
            Integer z = Integer.parseInt(st.nextToken());
            Integer P = Integer.parseInt(st.nextToken());
            city.add(z - 1);
            length.add(P);
        }
        Integer D = Integer.parseInt(bf.readLine());
        boolean [] vis = new boolean [N];
        int [] len = new int [N];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[D - 1] = 0;
        for(int i = 0; i < N; i++){
            int value = Integer.MAX_VALUE;
            int todo = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++){
                if(vis[j] == false && len[j] < value){
                    value = len[j];
                    todo = j;
                }
            }
            if(value != Integer.MAX_VALUE){
                vis[todo] = true;
                for(int j = 0; j < N; j++){
                    if(vis[j] == false && ai[todo][j] != Integer.MAX_VALUE && len[todo] + ai[todo][j] < len[j]) len[j] = len[todo] + ai[todo][j];
                }

            }
        }
        int cost = Integer.MAX_VALUE;
        for(int i = 0; i < city.size(); i++){
            if(len[city.get(i)] != Integer.MAX_VALUE) cost = Math.min(cost, len[city.get(i)] + length.get(i));
        }
        System.out.println(cost);
    }
}