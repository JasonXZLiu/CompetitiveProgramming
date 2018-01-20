import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int[][] triangle = new int[rows][];
        for (int x = 0; x < rows; x++) {
            triangle[x] = new int[x + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y = 0; y < triangle[x].length; y++)
                triangle[x][y] = Integer.parseInt(st.nextToken());
        }
        for (int x = rows - 2; x >= 0; x--)
            for (int y = 0; y < triangle[x].length; y++)
                triangle[x][y] += Math.max(triangle[x + 1][y], triangle[x + 1][y + 1]);
        System.out.println(triangle[0][0]);
    }
}
