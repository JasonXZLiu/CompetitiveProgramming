package com.jason.lotsofTriangles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 1/15/2017.
 */
public class TriangleWithPoints {
    Triangle triangle;
    List<Point> points;

    public TriangleWithPoints(Triangle triangle, List<Point> a) {
        this.triangle = triangle;
        this.points = a;
    }

    public List<Point> restPoints() {
        List<Point> rest = new ArrayList<Point>();
        for (final Point p : points) {
            if (p.getIndex() != triangle.a.getIndex() && p.getIndex() != triangle.b.getIndex() && p.getIndex() != triangle.c.getIndex()) {
                rest.add(p);
            }
        }
        return rest;
    }

    public void countInsidePoint() {
        int count = 0;
        for (final Point p : restPoints()) {
            count += triangle.checkPointInTriangle(p);
        }
        triangle.insiderCounter = count;
    }
}
