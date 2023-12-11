package edu.khai.renderer;

import com.jogamp.opengl.GL2;
import edu.khai.Camera;
import edu.khai.PointGenerator;
import edu.khai.math.structure.Point;
import edu.khai.math.structure.Triangle;
import lombok.extern.java.Log;

import java.util.List;

import static edu.khai.math.SphericalDelaunayTriangulation.triangulatePoints;

@Log
public class UniversalRenderer {

    Camera camera;
    Mode renderMode;

    List<Point> points;
    List<Triangle> triangles;

    SphereDotsRenderer sphereDotsRenderer;
    SphereTrianglesRenderer sphereTrianglesRenderer;

    public UniversalRenderer() {
        this.camera = Camera.getInstance();
        log.info("Starting generation of points");
        this.points = new PointGenerator().generatePoints();
        log.info("Starting triangulation of points");
        this.triangles = triangulatePoints(points);

        this.sphereDotsRenderer = new SphereDotsRenderer(points);
        this.sphereTrianglesRenderer = new SphereTrianglesRenderer(triangles);
    }

    public void render(GL2 gl){
        switch (renderMode) {
            case POINTS:
                sphereDotsRenderer.drawSpherePoints(gl, camera.getRotateX(), camera.getRotateY());
                break;
            case TRIANGLES:
                sphereTrianglesRenderer.drawSphereTriangles(gl, camera.getRotateX(), camera.getRotateY());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + renderMode);
        }
    }

    public void setRenderMode(Mode renderMode) {
        this.renderMode = renderMode;
    }

    public enum Mode{
        POINTS,
        TRIANGLES
    }
}
