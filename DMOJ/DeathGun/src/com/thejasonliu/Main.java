package com.thejasonliu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int E = in.nextInt(), tot = 0;
        String[] name = new String[901];
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer>[] adj = new ArrayList[901];
        for(int i = 0; i <= 900; i++)
            adj[i] = new ArrayList<Integer>();
        int[] indeg = new int[901];
        for (int i = 0; i < E; i++) {
            String x = in.next();
            String y = in.next();
            if(!map.containsKey(x)) {
                name[tot] = x;
                map.put(x, tot);
                tot++;
            }
            if(!map.containsKey(y)) {
                name[tot] = y;
                map.put(y, tot);
                tot++;
            }
            adj[map.get(y)].add(map.get(x)); indeg[map.get(x)]++;
        }
        while(true) {
            boolean flag = true;
            for(int i = 0; i < tot; i++) {
                if(indeg[i] == 0) {
                    indeg[i]--; flag=false;
                    System.out.println(name[i]);
                    for(int v: adj[i]) indeg[v]--;
                    break;
                }
            }
            if(flag) break;
        }
    }
}
