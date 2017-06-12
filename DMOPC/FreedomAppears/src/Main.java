import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long gcd(long bigger, long smaller) {
        while (true) {
            long remainder = bigger % smaller;
            if(remainder == 0){
                return smaller;
            }else{
                bigger=smaller;smaller=remainder;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        // write your code here
        FastReader s = new FastReader();
        long[] original = new long[3];
        for (int i = 0; i < 3; i++) {
            original[i] = s.nextLong();
        }
        int numEnemy = s.nextInt();
        long [][] pos = new long[numEnemy][3];
        int size = 1;
        long posX;
        long posY;
        long posZ;
        long res;
        for (int i = 0; i < numEnemy; i++) {
            boolean b = true;
            posX = s.nextLong() - original[0];
            posY = s.nextLong() - original[1];
            posZ = s.nextLong() - original[2];
            if(posY != 0 && posZ != 0 && posX != 0) {
                if (posX > posY) {
                    res = gcd(posX, posY);
                } else {
                    res = gcd(posY, posX);
                }
                if (res < posZ) {
                    res = gcd(posZ, res);
                } else {
                    res = gcd(res, posY);
                }
                posX = posX / res;
                posY = posY / res;
                posZ = posZ / res;
            } else if (posX == 0) {
                res = gcd(posY, posZ);
                posY = posY / res;
                posZ = posZ / res;
            } else if (posY == 0) {
                res = gcd(posX, posZ);
                posX = posX / res;
                posZ = posZ / res;
            } else {
                res = gcd(posX, posZ);
                posX = posX / res;
                posZ = posZ / res;
            }
            for (int j = 0; j < size; j++) {
                if (pos[j][0] == posX || pos[j][1] == posY || pos[j][2] == posZ) {
                    b = false;
                }
            }
            if (b) {
                pos[size - 1][0] = posX;
                pos[size - 1][1] = posY;
                pos[size - 1][2] = posZ;
                size++;
            }
        }
        System.out.println(size);
    }
}
