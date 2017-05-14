package com.jason.dontBeLast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jason on 1/16/2017.
 */
public class ProcessCows {

    List<Cow> cows = new ArrayList<>();
    int numCows;

    public void writeFile() throws IOException {
        String txt = cows.get(1).name;
        BufferedWriter bw = new BufferedWriter(new FileWriter("notlast.out"));
        bw.write(txt);
        bw.flush();
        bw.close();
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        int i = 0;
        while (i != numCows + 1) {
            if (i == 0) {
                numCows = Integer.parseInt(br.readLine());
            } else {
                Cow c = new Cow();
                String str = br.readLine();
                String[] arr = str.split(" ");
                c.name = arr[0];
                c.milk = Integer.parseInt(arr[1]);
//                System.out.println("name: " + c.name);
                cows.add(c);
            }
            i += 1;
//            System.out.println("i: " + i);
        }
        br.close();
    }

    public void checkName(String checkName, int i) {
//        System.out.println("first:" + checkName);
        for (int j = i + 1; j <= numCows - 1; j++) {
//            System.out.println("compare with: " + cows.get(j).name);
            if (checkName.equals(cows.get(j).name) && !(cows.get(j).getNeedDelete())) {
                cows.get(i).setMilk(cows.get(i).milk + cows.get(j).milk);
                cows.get(j).setNeedDelete(true);
            }
        }
    }

    public void checkDuplicate() {
        for (int i = 0; i < numCows - 1; i++) {
            if (!cows.get(i).getNeedDelete()) {
                String checkName = cows.get(i).name;
                checkName(checkName, i);
            }
        }
        cows = cows.stream().filter(cow -> ! cow.getNeedDelete()).collect(Collectors.toList());
    }

//    public void print(String str) {
//        System.out.println();
//        System.out.println(str);
//        for (int i = 0; i < numCows - 1; i++) {
//            System.out.println(cows.get(i).name + ": " + cows.get(i).milk);
//        }
//    }
}
