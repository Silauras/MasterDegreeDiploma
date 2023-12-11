package edu.khai;

import edu.khai.math.structure.Point;

import java.util.ArrayList;
import java.util.List;

import static edu.khai.Config.NUM_POINTS;
import static edu.khai.Config.SPHERE_RADIUS;

public class PointGenerator {

    public List<Point> generatePoints(){ // Генерация случайных точек на поверхности сферы
        List<Point> points = new ArrayList<>(NUM_POINTS);
        for (int i = 0; i < NUM_POINTS; i++) {
            double theta = Math.random() * 2 * Math.PI;
            double phi = Math.acos(2 * Math.random() - 1);
            double x = SPHERE_RADIUS * Math.sin(phi) * Math.cos(theta);
            double y = SPHERE_RADIUS * Math.sin(phi) * Math.sin(theta);
            double z = SPHERE_RADIUS * Math.cos(phi);
            points.add(new Point(x, y, z));
        }
        return points;
    }
}
