package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/3/2018.
 */
public class MaximumElement {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<S> stack = new Stack<>(); long MAX = Long.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if(A == 1) {
                long val = Long.parseLong(st.nextToken());
                MAX = Math.max(val, MAX);
                stack.push(new S(val, MAX));
            } else if(A == 2) {
                if(!stack.isEmpty())
                    stack.pop();
                if(stack.isEmpty())
                    MAX = Integer.MIN_VALUE;
                else
                    MAX = stack.peek().m;
            } else {
                System.out.println(stack.peek().m);
            }
        }
    }

    static class S {
        public long v, m;

        S(long v, long m) {this.v = v; this.m = m;}
    }
}
