package edu.khai.renderer;

import com.jogamp.opengl.GL2;
import edu.khai.math.structure.Point;
import edu.khai.math.structure.Triangle;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.khai.Config.POINT_SIZE;

public class SphereTrianglesRenderer {
    private final List<Triangle> triangles;
    Map<Triangle, Color> triangleColorMap = new HashMap<>();

    public SphereTrianglesRenderer(List<Triangle> triangles) {

        this.triangles = triangles;

        for (Triangle triangle : triangles) {
            float red = (float) Math.random();
            float green = (float) Math.random();
            float blue = (float) Math.random();

            this.triangleColorMap.put(triangle, new Color(red, green, blue));
        }
    }


    public void drawSphereTriangles(GL2 gl, float rotateX, float rotateY) {
        gl.glTranslatef(0.0f, 0.0f, -3.0f);
        gl.glRotatef(rotateX, 1f, 0, 0);
        gl.glRotatef(rotateY, 0, 1, 0);
        gl.glBegin(GL2.GL_TRIANGLES);

        for (Triangle triangle : triangles) {
            Color color = this.triangleColorMap.get(triangle);
            // Установка цвета перед треугольником
            gl.glColor3f(
                    (float) color.getRed() / 255,
                    (float) color.getGreen() / 255,
                    (float) color.getBlue() / 255);

            // Отрисовка треугольника
            for (Point point : triangle.getVertices()) {
                gl.glVertex3d(point.x, point.y, point.z);
            }
        }

        gl.glEnd();
        gl.glFlush();
    }
}
