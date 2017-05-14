package com.jason.lotsofTriangles;

/**
 * Created bb Jason on 1/15/2017.
 */
public class Triangle {
    Point a;
    Point b;
    Point c;
    int insiderCounter;

    public int getInsiderCounter () {
        return insiderCounter;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB (Point b) {
        this.b = b;
    }

    public void setC (Point c) {
        this.c = c;
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static int calculateFactorial (int num) {
        int result = 1;
        if(num != 1) {
            for (int i = num; i > 1; i--) {
                result *= i;
            }
        }
        return result;
    }

    public static int calculateDoubleArea (Point A, Point B, Point C) {
        int area = A.getX()*B.getY()-A.getY()*B.getX()+B.getX()*C.getY()-B.getY()*C.getX()+C.getX()*A.getY()-C.getY()*A.getX();
        if (area < 0) {
            area = - area;
        }
        return area;
    }

    public static int checkPossibleTriangles(int pointNum) {
        int possibilities;
        possibilities = calculateFactorial(pointNum) / (calculateFactorial(pointNum-3) * calculateFactorial(3));
        return possibilities;
    }

    public void printTriangles () {
        System.out.println("Triangle as: ");
        a.print("point a: ");
        b.print("point b: ");
        c.print("point c: ");
    }

    public int checkPointInTriangle(Point p) {
        int total = calculateDoubleArea(a,b,c);
        int abp = calculateDoubleArea(a,b,p);
        int apc = calculateDoubleArea(a,p,c);
        int pbc = calculateDoubleArea(p,b,c);
        if (total == abp + apc + pbc) {
            return 1;
        }
        return 0;
    }
}
