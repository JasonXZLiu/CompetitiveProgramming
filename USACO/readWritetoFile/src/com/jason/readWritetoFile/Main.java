package com.jason.readWritetoFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] txt;
        txt = readFile();
        writeFile(txt);
    }

    public static void writeFile(String[] txt) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("square.out.txt"));
        for (int i = 0; i < txt.length; i++) {
            bw.write(txt[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static String[] readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in.txt"));
        int numberOfLines = 2;
        String[] txt = new String[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {
            txt[i] = br.readLine();
        }
        return txt;
    }

}
