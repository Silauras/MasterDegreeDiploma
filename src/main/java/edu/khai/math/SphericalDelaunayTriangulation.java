package edu.khai.math;

import edu.khai.math.structure.Edge;
import edu.khai.math.structure.Point;
import edu.khai.math.structure.Triangle;

import java.util.*;

public class SphericalDelaunayTriangulation {

    public static List<Triangle> triangulatePoints(List<Point> points) {
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < points.size() - 2; i++) {
            for (int j = i + 1; j < points.size() - 1; j++) {
                for (int k = j + 1; k < points.size(); k++) {
                    Triangle triangle = new Triangle(points.get(i), points.get(j), points.get(k));
                    boolean isNoOtherPoints = true;
                    for (Point point: points) {
                        if (point == triangle.getVertex1() || point == triangle.getVertex2() || point == triangle.getVertex3()){
                            continue;
                        }
                        if (triangle.isPointInsideInCircle(point)){
                            isNoOtherPoints = false;
                            break;
                        }
                    }
                    if (isNoOtherPoints){
                        triangles.add(triangle);
                    }

                }
            }
        }
        return triangles;
    }

    private static List<Edge> findPolygonEdges(List<Triangle> triangles) {
        List<Edge> edges = new ArrayList<>();
        for (Triangle triangle : triangles) {
            edges.add(new Edge(triangle.getVertex(0), triangle.getVertex(1)));
            edges.add(new Edge(triangle.getVertex(1), triangle.getVertex(2)));
            edges.add(new Edge(triangle.getVertex(2), triangle.getVertex(0)));
        }
        return edges;
    }
}
