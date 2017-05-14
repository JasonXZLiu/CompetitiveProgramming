package com.jason.dontBeLast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ProcessCows r = new ProcessCows();
        r.readFile();
//        r.print("before");
        r.checkDuplicate();
//        r.print("after duplicate");
        Collections.sort(r.cows, new Cow());
        r.cows.forEach(cow -> System.out.println(cow));
//        r.print("after sort");
        r.writeFile();
    }
}



