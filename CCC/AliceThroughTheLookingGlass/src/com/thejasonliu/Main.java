package com.thejasonliu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++) {
            double L = Math.pow(5, in.nextInt());
            int x = in.nextInt();
            int y = in.nextInt();
            if(Math.floor(y / L) == 0) {
                if(y % 5 == 0 && x % 5 <= 3 && x % 5 >= 1) {
                    System.out.println("crystal");
                } else if (y % 5 <= 1 && x % 5 == 2) {
                    System.out.println("crystal");
                } else {
                    System.out.println("empty");
                }
            } else {
                System.out.println("empty");
            }
        }
    }
}
