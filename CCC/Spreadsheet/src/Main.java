import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] adj = new int[10][9];
    public static String[][] str = new String[10][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                str[i][j] = st.nextToken();
                adj[i][j] = -1;
            }
        }

        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 9; j++) {
                    StringTokenizer st = new StringTokenizer(str[i][j], "+");
                    int v = 0;
                    int x = 0;
                    while (st.hasMoreTokens() && x != -1) {
                        x = Value(st.nextToken());
                        if (x == -1)
                            v = -1;
                        else
                            v += x;
                    }
                    if (adj[i][j] != v) {
                        change = true;
                        adj[i][j] = v;
                    }
                }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++)
                if (adj[i][j] == -1)
                    System.out.print("* ");
                else
                    System.out.print(adj[i][j] + " ");
            System.out.println();
        }

    }


    public static int Value(String s) {
        int v;
        if (s.charAt(0) >= 'A' && s.charAt(0) <= 'J')
            v = adj[s.charAt(0) - 'A'][s.charAt(1) - '1'];
        else
            v = Integer.parseInt(s);
        return v;
    }
}