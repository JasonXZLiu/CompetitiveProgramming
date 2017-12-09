package com.thejasonliu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FastReader in = new FastReader();
        int[][] ss = new int[10][9];
        HashMap<Q, String[]> map = new HashMap<>();
        Queue<Q> blap = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                String a = in.next();
                if (isInteger(a)) {
                    ss[i][j] = Integer.parseInt(a);
                } else {
                    String[] tmp = a.split("\\+");
                    boolean b = true;
                    int total = 0;
                    for (String blah : tmp) {
                        int tmp1;
                        switch (blah.substring(0, 1)) {
                            case "A":
                                tmp1 = 0;
                                break;
                            case "B":
                                tmp1 = 1;
                                break;
                            case "C":
                                tmp1 = 2;
                                break;
                            case "D":
                                tmp1 = 3;
                                break;
                            case "E":
                                tmp1 = 4;
                                break;
                            case "F":
                                tmp1 = 5;
                                break;
                            case "G":
                                tmp1 = 6;
                                break;
                            case "H":
                                tmp1 = 7;
                                break;
                            case "I":
                                tmp1 = 8;
                                break;
                            default:
                                tmp1 = 9;
                                break;
                        }
                        int boop = Integer.parseInt(blah.substring(1));
                        if (boop - 1 >= 0 && boop <= 9) {
                            if (ss[tmp1][boop-1] != 0) {
                                total += ss[tmp1][boop-1];
                            } else {
                                b = false;
                            }
                        } else {
                            b = false;
                        }
                    }
                    if (b) {ss[i][j] = total;}
                    else {ss[i][j] = -1; Q qtemp = new Q(i, j); blap.add(qtemp); map.put(qtemp, tmp);}
                }
            }
        }
        while (!blap.isEmpty()) {
            int tmp1, total = 0;
            Q temp = blap.poll();
            String[] tmp = map.get(temp);
            int i = temp.x;
            int j = temp.y;
            boolean b = true;
            for (String blah : tmp) {
                switch (blah.substring(0, 1)) {
                    case "A":
                        tmp1 = 0;
                        break;
                    case "B":
                        tmp1 = 1;
                        break;
                    case "C":
                        tmp1 = 2;
                        break;
                    case "D":
                        tmp1 = 3;
                        break;
                    case "E":
                        tmp1 = 4;
                        break;
                    case "F":
                        tmp1 = 5;
                        break;
                    case "G":
                        tmp1 = 6;
                        break;
                    case "H":
                        tmp1 = 7;
                        break;
                    case "I":
                        tmp1 = 8;
                        break;
                    default:
                        tmp1 = 9;
                        break;
                }
                int boop = Integer.parseInt(blah.substring(1));
                if (ss[tmp1][boop - 1] >= 0) {
                    total += ss[tmp1][boop - 1];
                }
            }
            if (b) {ss[i][j] = total;}
            else {ss[i][j] = -1; Q qtemp = new Q(i, j); blap.add(qtemp); map.put(qtemp, tmp);}
        }


        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if(ss[i][j] <= -1) {System.out.print("* ");}
                else {System.out.print(ss[i][j] + " ");}
            }
            System.out.println();
        }
    }

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
        }

        return isValidInteger;
    }

    static class Q {
        public int x, y;

        Q(int x0, int y0) {x = x0; y = x0;}
    }

    static class FastReader
    {
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
}
