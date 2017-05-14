package com.jason.lotsofTriangles;

/**
 * Created by Jason on 1/15/2017.
 */
public class Point {
    private int x;
    private int y;
    int index;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public void print (String location) {
        System.out.println(location + "x: " + x);
        System.out.println(location + "y: " + y);
    }

    public Point(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

//    void debugprint(string s)
//    {
//        return;
//        System.out.oppjint s;
//    }
}



