package edu.khai.math.structure;

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

    public boolean isPointInsideInCircle(Point newPoint) {
        double a = vertex2.distanceTo(vertex3);
        double b = vertex3.distanceTo(vertex1);
        double c = vertex1.distanceTo(vertex2);

        double P = a + b + c;
        double s = P / 2.0;

        double inradius = Math.sqrt((s - a) * (s - b) * (s - c) / s);

        double d1 = newPoint.distanceTo(vertex1);
        double d2 = newPoint.distanceTo(vertex2);
        double d3 = newPoint.distanceTo(vertex3);

        double s1 = (a + d1 + d2) / 2.0;
        double s2 = (b + d2 + d3) / 2.0;
        double s3 = (c + d3 + d1) / 2.0;

        double A1 = Math.sqrt(s1 * (s1 - a) * (s1 - d1) * (s1 - d2));
        double A2 = Math.sqrt(s2 * (s2 - b) * (s2 - d2) * (s2 - d3));
        double A3 = Math.sqrt(s3 * (s3 - c) * (s3 - d3) * (s3 - d1));

        double area = A1 + A2 + A3;

        double incircleRadius = 2 * area / P;

        return inradius > incircleRadius;
    }

    public Point[] getVertices() {
        return new Point[]{vertex1, vertex2, vertex3};
    }
}
