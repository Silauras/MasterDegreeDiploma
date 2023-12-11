package edu.khai.math;

import edu.khai.math.structure.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphericalDelaunayTriangulationTest {

    // Тест для chooseInitialTriangle
//    @Test
//    public void testChooseInitialTriangle() {
//        Point[] points = {
//                new Point(1.0, 0.0, 0.0),
//                new Point(0.0, 1.0, 0.0),
//                new Point(0.0, 0.0, 1.0),
//                new Point(-1.0, 0.0, 0.0),
//                new Point(0.0, -1.0, 0.0),
//                new Point(0.0, 0.0, -1.0)
//        };
//
//        List<Point> initialTriangle = SphericalDelaunayTriangulation.chooseInitialTriangle(points);
//
//        // Проверяем, что точки из начального треугольника присутствуют в массиве точек
//        assertTrue(Arrays.asList(points).containsAll(initialTriangle));
//
//        // Проверяем, что все три точки разные
//        assertEquals(3, initialTriangle.stream().distinct().count());
//    }
//
//    // Тест для findNearestPoint
//    @Test
//    public void testFindNearestPoint() {
//        Point reference = new Point(1.0, 0.0, 0.0);
//        Point[] points = {
//                new Point(1.0, 1.0, 0.0),
//                new Point(0.0, 1.0, 0.0),
//                new Point(0.0, 0.0, 1.0),
//                new Point(-1.0, 0.0, 0.0),
//                new Point(0.0, -1.0, 0.0),
//                new Point(0.0, 0.0, -1.0)
//        };
//
//        Point nearestPoint = SphericalDelaunayTriangulation
//                .findNearestPoints(PointMath
//                        .calculateGeodesicDistances(points, reference), 1)
//                .get(0);
//
//        // Проверяем, что найденная точка присутствует в массиве точек
//        assertTrue(Arrays.asList(points).contains(nearestPoint));
//    }
//
//    // Тест для findNearestPoints
//    @Test
//    public void testFindNearestPoints() {
//        Point reference = new Point(1.0, 0.0, 0.0);
//        Point[] points = {
//                new Point(1.0, 1.0, 0.0),
//                new Point(0.0, 1.0, 0.0),
//                new Point(0.0, 0.0, 1.0),
//                new Point(-1.0, 0.0, 0.0),
//                new Point(0.0, -1.0, 0.0),
//                new Point(0.0, 0.0, -1.0)
//        };
//
//        List<Point> nearestPoints = SphericalDelaunayTriangulation
//                .findNearestPoints(PointMath
//                        .calculateGeodesicDistances(points, reference), 2);
//
//        // Проверяем, что найденные точки присутствуют в массиве точек
//        assertTrue(Arrays.asList(points).containsAll(nearestPoints));
//
//        // Проверяем, что найденные точки разные
//        assertEquals(2, nearestPoints.stream().distinct().count());
//    }
}