package edu.khai.math;

import edu.khai.Config;
import edu.khai.math.structure.Point;

import java.util.HashMap;
import java.util.Map;

public class PointMath {
    public static float calculateGeodesicDistance(Point p1, Point p2) {
        double dX = p2.x - p1.x;
        double dY = p2.y - p1.y;
        double dZ = p2.z - p1.z;

        double a = Math.sin(dX / 2) * Math.sin(dX / 2) +
                Math.cos(p1.x) * Math.cos(p2.x) *
                        Math.sin(dY / 2) * Math.sin(dY / 2) +
                Math.cos(p1.x) * Math.cos(p2.x) *
                        Math.sin(dZ / 2) * Math.sin(dZ / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Вычисление геодезического расстояния
        return (float) (Config.SPHERE_RADIUS * c);
    }

    public static Map<Point, Map<Point, Float>> calculateGeodesicDistances(Point[] points) {
        Map<Point, Map<Point, Float>> distanceMap = new HashMap<>();

        for (Point p1 : points) {
            Map<Point, Float> innerMap = calculateGeodesicDistances(points, p1);
            distanceMap.put(p1, innerMap);
        }

        return distanceMap;
    }

    public static Map<Point, Float> calculateGeodesicDistances(Point[] points, Point reference) {
        Map<Point, Float> innerMap = new HashMap<>();
        for (Point p2 : points) {
            if (!reference.equals(p2)) {
                float distance = calculateGeodesicDistance(reference, p2);
                innerMap.put(p2, distance);
            }
        }
        return innerMap;
    }
}
