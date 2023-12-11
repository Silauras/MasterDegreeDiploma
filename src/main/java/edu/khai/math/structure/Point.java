package edu.khai.math.structure;

import edu.khai.Config;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public  class Point {
    public final double x, y, z;

    public float geodesicDistanceTo(Point other) {
        double dX = other.x - this.x;
        double dY = other.y - this.y;
        double dZ = other.z - this.z;

        double a = Math.sin(dX / 2) * Math.sin(dX / 2) +
                Math.cos(this.x) * Math.cos(other.x) *
                        Math.sin(dY / 2) * Math.sin(dY / 2) +
                Math.cos(this.x) * Math.cos(other.x) *
                        Math.sin(dZ / 2) * Math.sin(dZ / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (float) (Config.SPHERE_RADIUS * c);
    }

    public float distanceTo(Point other) {
        double dX = other.x - this.x;
        double dY = other.y - this.y;
        double dZ = other.z - this.z;
        return (float) Math.sqrt(dX * dX + dY * dY + dZ * dZ);
    }

    // Переопределяем методы equals и hashCode для корректной работы с коллекциями
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}