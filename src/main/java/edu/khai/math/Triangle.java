package edu.khai.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Triangle {

    private final Point vertex1, vertex2, vertex3;

    public Point getVertex(int index) {
        switch (index) {
            case 0:
                return vertex1;
            case 1:
                return vertex2;
            case 2:
                return vertex3;
            default:
                throw new IllegalArgumentException("Invalid vertex index: " + index);
        }
    }

    public boolean isPointInsideCircumcircle(Point newPoint) {
        double ax = vertex1.x - newPoint.x;
        double ay = vertex1.y - newPoint.y;
        double bx = vertex2.x - newPoint.x;
        double by = vertex2.y - newPoint.y;
        double cx = vertex3.x - newPoint.x;
        double cy = vertex3.y - newPoint.y;

        double ab = ax * by - ay * bx;
        double bc = bx * cy - by * cx;
        double ca = cx * ay - cy * ax;

        double aSquared = ax * ax + ay * ay;
        double bSquared = bx * bx + by * by;
        double cSquared = cx * cx + cy * cy;

        double circumcircleTest = aSquared * bc + bSquared * ca + cSquared * ab;

        return circumcircleTest > 0;
    }

    public Point[] getVertices() {
        return new Point[]{vertex1, vertex2, vertex3};
    }
}
