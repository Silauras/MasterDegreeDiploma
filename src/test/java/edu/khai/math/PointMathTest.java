package edu.khai.math;

import edu.khai.math.structure.Point;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PointMathTest {

    // Тест для calculateGeodesicDistance
    @Test
    public void testCalculateGeodesicDistance() {
        Point p1 = new Point(0.0, 0.0, 0.0);
        Point p2 = new Point(1.0, 0.0, 0.0);

        float distance = PointMath.calculateGeodesicDistance(p1, p2);

        // Проверяем, что расстояние корректно вычислено
        assertEquals(1.0, distance, 0.001);
    }

    // Тест для calculateGeodesicDistances (всех точек)
    @Test
    public void testCalculateGeodesicDistancesAllPoints() {
        Point[] points = {
                new Point(1.0, 0.0, 0.0),
                new Point(0.0, 1.0, 0.0),
                new Point(0.0, 0.0, 1.0),
                new Point(-1.0, 0.0, 0.0),
                new Point(0.0, -1.0, 0.0),
                new Point(0.0, 0.0, -1.0)
        };

        Map<Point, Map<Point, Float>> distanceMap = PointMath.calculateGeodesicDistances(points);

        // Проверяем, что расстояния корректно вычислены для всех точек
        for (Point p1 : points) {
            for (Point p2 : points) {
                if (!p1.equals(p2)) {
                    assertTrue(distanceMap.containsKey(p1));
                    assertTrue(distanceMap.get(p1).containsKey(p2));
                    float distance = PointMath.calculateGeodesicDistance(p1, p2);
                    assertEquals(distance, distanceMap.get(p1).get(p2), 0.001);
                }
            }
        }
    }

    // Тест для calculateGeodesicDistances (отдельной точки)
    @Test
    public void testCalculateGeodesicDistancesSinglePoint() {
        Point[] points = {
                new Point(1.0, 0.0, 0.0),
                new Point(0.0, 1.0, 0.0),
                new Point(0.0, 0.0, 1.0),
                new Point(-1.0, 0.0, 0.0),
                new Point(0.0, -1.0, 0.0),
                new Point(0.0, 0.0, -1.0)
        };

        Point reference = new Point(1.0, 0.0, 0.0);

        Map<Point, Float> innerMap = PointMath.calculateGeodesicDistances(points, reference);

        // Проверяем, что расстояния корректно вычислены для отдельной точки
        for (Point p2 : points) {
            if (!reference.equals(p2)) {
                assertTrue(innerMap.containsKey(p2));
                float distance = PointMath.calculateGeodesicDistance(reference, p2);
                assertEquals(distance, innerMap.get(p2), 0.001);
            }
        }
    }
}