package com.jason.lotsofTriangles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Point nextLine(int i) {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            String[] parts = str.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            return new Point(x, y, i);
        }
    }

    private static List<Triangle> createTriangles(List<Point> points, int numPoints) {
        List<Triangle> triangles = new ArrayList<Triangle>();
        Point firstPoint;
        Point secondPoint;
        Point thirdPoint;
        for (int i = 0; i < numPoints; i++) {
            firstPoint = points.get(i);
            for (int j = i + 1; j < numPoints; j++) {
                secondPoint = points.get(j);
                for (int k = j + 1; k < numPoints; k++) {
                    thirdPoint = points.get(k);
                    triangles.add(new Triangle(firstPoint, secondPoint, thirdPoint));
                }
            }
        }
        return triangles;
    }

    public static void main(String[] args) {
        // write your code here
        FastReader s = new FastReader();
        List<Point> points = new ArrayList<>();
        int PointNum = s.nextInt();
        for (int i = 0; i < PointNum; i++) {
            Point p = s.nextLine(i);
            points.add(p);
        }
        int numTriangles = Triangle.checkPossibleTriangles(PointNum);
        System.out.println("numTriangles: " + numTriangles);
        List<Triangle> triangles = createTriangles(points, PointNum);
        for (int i = 0; i < numTriangles; i++) {
            Triangle fixedTriangle = triangles.get(i);
            TriangleWithPoints trianglePoints = new TriangleWithPoints(fixedTriangle, points);
            trianglePoints.countInsidePoint();
        }
        Integer[] numPoints = new Integer[PointNum - 2];
        Arrays.fill(numPoints, 0);
        for (final Triangle twp : triangles) {
            numPoints[twp.getInsiderCounter()] += 1;
        }
        for (int count: numPoints) {
            System.out.println(count);
        }
    }
}