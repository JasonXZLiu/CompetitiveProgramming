import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[]args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] iaa = new int [N];
        for(int i = 0; i < N; i++) iaa[i] = Integer.parseInt(st.nextToken());
        int [] iab = new int [N];
        int i, j;
        iab[0] = 0;
        for(i = 1; i < N; i++){
            for(j = i - 1; j > 0;){
                if(iaa[i] < iaa[j]) break;
                else j = j - iab[j];
            }
            iab[i] = i - j;
        }
        for(i = 0; i < N - 1; i++) System.out.print(iab[i] + " ");
        System.out.print(iab[i]);
        System.out.println(" ");
    }
}