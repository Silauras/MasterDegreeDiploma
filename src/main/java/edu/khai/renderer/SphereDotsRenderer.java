package edu.khai.renderer;

import com.jogamp.opengl.GL2;
import edu.khai.math.Point;

import static edu.khai.Config.SPHERE_RADIUS;

public class SphereDotsRenderer {
    Point[] spherePoints;

    public SphereDotsRenderer(Point[] spherePoints) {
        this.spherePoints = spherePoints;
    }

    public void drawSpherePoints(GL2 gl, float rotateX, float rotateY) {
        gl.glTranslatef(0.0f, 0.0f, -3.0f);
        gl.glRotatef(rotateX, 1f, 0, 0);
        gl.glRotatef(rotateY, 0, 1, 0);
        gl.glPointSize(1f);
        gl.glBegin(GL2.GL_POINTS);

        for (Point point : spherePoints) {
            double scaledZ = (point.z + SPHERE_RADIUS) / 2.0; // масштабирование z в диапазон [0.0, 1.0]
            gl.glVertex3d(point.x, point.y, point.z);
            gl.glColor3d(scaledZ, scaledZ, scaledZ);
        }

        gl.glEnd();
        gl.glFlush();
    }
}
