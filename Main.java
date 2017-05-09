import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
////        class FastReader {
////            BufferedReader br;
////            StringTokenizer st;
////
////            public FastReader() throws FileNotFoundException {
////                br = new BufferedReader(new
////                        InputStreamReader(System.in));
////            }
////
////            String next() {
////                while (st == null || !st.hasMoreElements()) {
////                    try {
////                        st = new StringTokenizer(br.readLine());
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////                return st.nextToken();
////            }
////
////            int nextInt() {
////                return Integer.parseInt(next());
////            }
////
////            long nextLong() {
////                return Long.parseLong(next());
////            }
////
////            double nextDouble() {
////                return Double.parseDouble(next());
////            }
////
////            String nextLine() {
////                String str = "";
////                try {
////                    str = br.readLine();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////                return str;
////            }
////        }
//        FastReader f = new FastReader();
//        for (int t = 0; t < 6; t++) {
        Scanner f = new Scanner(System.in);
        for (int a = 0; a < 6; a++){
            int c = f.nextInt();
            if (c == 1) {
                int spaceMiles = f.nextInt() + 1;
                int initialFuel = f.nextInt();
                int numRefuel = f.nextInt();
                int[] planets = new int[spaceMiles];
                planets[0] = initialFuel;
                int[] dp = new int[spaceMiles];
                int temp;
                int lastMove = 0;
                for (int i = 0; i < numRefuel; i++) {
                    temp = f.nextInt();
                    planets[temp] = f.nextInt();
                }
                for (int i = 0; i < spaceMiles; i++) {
                    if (planets[i] != 0) {
                        int distance = planets[i];
                        lastMove = 0;
                        if (dp[i] == 0) {
                            dp[i + 1] += 1;
                            if (i + distance + 1 < spaceMiles) {
                                dp[i + distance + 1] -= 1;
                            }
                        } else {
                            dp[i + 1] += dp[i];
                            if (i + distance + 1 < spaceMiles) {
                                dp[i + distance + 1] -= dp[i];
                            }
                        }
                    } else {
                        if (lastMove == 1) {
                            for (int j = 0; j < spaceMiles - 1; j++) {
                                dp[j + 1] += dp[j];
                            }
                        }
                        lastMove = 1;
                    }
                }
                System.out.println(dp[spaceMiles - 1]);
            }
        }
//        }

    }
}



